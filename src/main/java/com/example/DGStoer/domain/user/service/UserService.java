package com.example.DGStoer.domain.user.service;

import com.example.DGStoer.domain.user.dto.SigninResponse;
import com.example.DGStoer.domain.user.entity.User;
import com.example.DGStoer.domain.user.repository.UserRepository;
import com.example.DGStoer.global.infra.dauth.DodamInfraService;
import com.example.DGStoer.global.infra.dauth.DodamOpenService;
import com.example.DGStoer.global.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    private final DodamInfraService dodamInfraService;

    private final JwtService jwtService;

    public SigninResponse signInWithOAuth(String code) {
        String dodamAccessToken = dodamInfraService.getToken(code);
        DodamOpenService.UserResponse userInfo = dodamInfraService.getUserInfo(dodamAccessToken);

        Optional<User> found = userRepository.findByBindInfraId(userInfo.getData().getUniqueId());
        if(!found.isPresent()) {
            User newUser = User.builder()
                    .name(userInfo.getData().getName())
                    .bindInfraId(userInfo.getData().getUniqueId())
                    .build();

            User saved = userRepository.save(newUser);


            return new SigninResponse(jwtService.generateToken(saved.getId()));
        }

        return new SigninResponse(jwtService.generateToken(found.get().getId()));
    }

}
