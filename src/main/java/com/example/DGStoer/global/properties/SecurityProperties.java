package com.example.DGStoer.global.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties("security") @EnableConfigurationProperties
@Data
public class SecurityProperties {
    private String jwtSecret;
}
