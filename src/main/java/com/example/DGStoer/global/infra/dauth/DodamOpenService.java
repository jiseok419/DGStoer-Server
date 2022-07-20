package com.example.DGStoer.global.infra.dauth;

import lombok.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface DodamOpenService {
    @Data
    public static class UserResponse {
        private Integer status;

        private String message;

        private Data data;

        @lombok.Data
        public static class Data {
            private String uniqueId;
            private Integer grade;
            private Integer room;
            private Integer number;
            private String name;
            private String profileImage;
            private String accessLevel;
            private String email;
        }
    }

    @GET("/api/user")
    public Call<UserResponse> getUserInfo(@Header("Authorization") String authorization);
}
