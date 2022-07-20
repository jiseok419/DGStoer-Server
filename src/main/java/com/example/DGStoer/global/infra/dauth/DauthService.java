package com.example.DGStoer.global.infra.dauth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.Map;

public interface DauthService {
    @Data
    public static class TokenResponse {
        @JsonProperty("access_token")
        private String accessToken;

        @JsonProperty("refresh_token")
        private String refreshToken;

        @JsonProperty("token_type")
        private String tokenType;

        @JsonProperty("expires_in")
        private String expiresIn;
    }

    @Builder
    @Data
    public static class TokenRequest {
        @JsonProperty("code")
        private String code;

        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("client_secret")
        private String clientSecret;
    }

    @POST("/api/token")
    public Call<TokenResponse> getToken(@Body TokenRequest body);
}
