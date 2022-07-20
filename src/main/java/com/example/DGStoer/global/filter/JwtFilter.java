package com.example.DGStoer.global.filter;

import com.example.DGStoer.domain.user.entity.User;
import com.example.DGStoer.domain.user.repository.UserRepository;
import com.example.DGStoer.global.security.JwtAuthentication;
import com.example.DGStoer.global.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if(header != null && jwtService.validateToken(header.split("Bearer ")[1])) {
            Long userId = Long.valueOf(jwtService.getUserId(header.split("Bearer ")[1]));
            log.info("User id: {}", userId);

            User user = userRepository.findById(userId).orElseThrow();
            Authentication authentication = new JwtAuthentication(user);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}
