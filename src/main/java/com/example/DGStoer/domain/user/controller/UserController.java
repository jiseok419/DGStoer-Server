package com.example.DGStoer.domain.user.controller;

import com.example.DGStoer.domain.user.dto.SigninResponse;
import com.example.DGStoer.domain.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation("로그인")
    @GetMapping("/signin")
    public SigninResponse signInWithOAuth(@RequestParam("code") String code){
        return userService.signInWithOAuth(code);
    }
}