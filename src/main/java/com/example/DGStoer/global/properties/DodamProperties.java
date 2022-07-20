package com.example.DGStoer.global.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@ConfigurationProperties("dodam") @EnableConfigurationProperties
public class DodamProperties {
    private String clientId;
    private String clientSecret;
}
