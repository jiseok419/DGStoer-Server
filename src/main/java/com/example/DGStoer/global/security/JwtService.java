package com.example.DGStoer.global.security;

import com.example.DGStoer.global.properties.SecurityProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
public class JwtService {
    private final SecurityProperties securityProperties;
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(securityProperties.getJwtSecret())
                    .parseClaimsJws(token);
            return true;
        }catch (Exception ex) {
            return false;
        }
    }

    public Long getUserId(String token) {
        try {
            String id = Jwts.parser()
                    .setSigningKey(securityProperties.getJwtSecret())
                    .parseClaimsJws(token)
                    .getBody().getId();
            return Long.valueOf(id);
        }catch (Exception ex) {
            return -1L;
        }
    }

    public String generateToken(Long userId) {
        Date date = new Date();

        return Jwts.builder().setId(String.valueOf(userId))
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, securityProperties.getJwtSecret())
                .compact();
    }


}
