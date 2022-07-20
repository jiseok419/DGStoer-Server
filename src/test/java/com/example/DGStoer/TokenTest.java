package com.example.DGStoer;

import com.example.DGStoer.global.security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TokenTest {
    @Autowired
    private JwtService jwtService;

    @Test
    public void generateToken() {
        System.out.println(jwtService.generateToken(0L));
    }
}
