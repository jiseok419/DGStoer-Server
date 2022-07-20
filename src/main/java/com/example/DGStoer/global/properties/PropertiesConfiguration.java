package com.example.DGStoer.global.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfiguration {
    @Bean
    public DodamProperties dodamProperties() {
        return new DodamProperties();
    }

    @Bean
    public SecurityProperties securityProperties() {
        return new SecurityProperties();
    }
}
