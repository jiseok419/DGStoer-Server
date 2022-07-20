package com.example.DGStoer.global.security;

import com.example.DGStoer.domain.user.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.ArrayList;

public class JwtAuthentication extends UsernamePasswordAuthenticationToken {
    public JwtAuthentication(User user) {
        super(user, null, new ArrayList<>());
    }
}
