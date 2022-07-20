package com.example.DGStoer.global.infra.dauth;

import com.example.DGStoer.global.properties.DodamProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Response;

@RequiredArgsConstructor
@Service
public class DodamInfraService {
    private final DauthService dauthService;
    private final DodamOpenService dodamOpenService;

    private final DodamProperties dodamProperties;

    public String getToken(String code) {
        DauthService.TokenRequest body = DauthService.TokenRequest.builder()
                .code(code)
                .clientId(dodamProperties.getClientId())
                .clientSecret(dodamProperties.getClientSecret())
                .build();

        try {
            DauthService.TokenResponse response = dauthService.getToken(body).execute().body();
            System.out.println(response);
            return response.getAccessToken();
        }catch (Exception ex) {
            throw new RuntimeException("파싱 실패");
        }

    }

    public DodamOpenService.UserResponse getUserInfo(String accessToken) {
        try {
            Response<DodamOpenService.UserResponse> res = dodamOpenService.getUserInfo("Bearer " + accessToken).execute();
            return res.body();
        }catch (Exception ex) {
            throw new RuntimeException("파싱 실패");
        }
    }


}
