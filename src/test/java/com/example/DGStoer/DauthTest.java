package com.example.DGStoer;

import com.example.DGStoer.global.infra.dauth.DauthService;
import com.example.DGStoer.global.infra.dauth.DodamOpenService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Response;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class DauthTest {

    private String accessToken;

    @Autowired
    private DauthService dauthService;

    @Autowired
    private DodamOpenService dodamOpenService;

    @Order(1)
    @DisplayName("토큰 조회")
    @Test
    void getToken() throws Exception {
       // @Field("code") String code, @Field("client_id") String clientId, @Field("client_secret") String clientSecre

        DauthService.TokenRequest body = DauthService.TokenRequest.builder()
                .code("f32849384928r93f9v8r39f8943w8r9")
                .clientId("f502c9bed12443da89d6ffe69a9cd78de2b4a3b4556c45ce9688bdf5baf0d47c")
                .clientSecret("f32bbded6fc14aed94b481e7cad1b735dcbefb9419064dc8a55f86e535d2b1cd")
                .build();

        DauthService.TokenResponse response = dauthService.getToken(body).execute().body();
        System.out.println(response);
        accessToken = response.getAccessToken();
    }

    @Order(2)
    @DisplayName("사용자 정보 조회")
    @Test
    void getUserInfo() throws Exception {
        Response<DodamOpenService.UserResponse> res = dodamOpenService.getUserInfo("Bearer " + accessToken).execute();
        System.out.println(res.code());
        System.out.println(res.errorBody());
        System.out.println(res.message());
        System.out.println(res.body());
    }

}
