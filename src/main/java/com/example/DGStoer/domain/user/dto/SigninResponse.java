package com.example.DGStoer.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class SigninResponse {
    @JsonProperty("access_token")
    private String accessToken;
}
