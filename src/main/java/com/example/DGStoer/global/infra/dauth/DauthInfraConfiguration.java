package com.example.DGStoer.global.infra.dauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class DauthInfraConfiguration {
    @Bean
    public DauthService dauthService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dauth.b1nd.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(DauthService.class);
    }

    @Bean
    public DodamOpenService dodamOpenService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://open.dodam.b1nd.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        return retrofit.create(DodamOpenService.class);
    }
}
