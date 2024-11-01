package com.tasklist.task_list_clean_architecture.application.service;

import com.tasklist.task_list_clean_architecture.application.dto.request.LoginUserDto;
import com.tasklist.task_list_clean_architecture.application.dto.request.RegisterUserDto;
import com.tasklist.task_list_clean_architecture.application.dto.response.JwtResponse;
import com.tasklist.task_list_clean_architecture.application.service.usercase.auth.AuthLoginUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.auth.AuthRegisterUseCase;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthService {

    private final AuthRegisterUseCase registerUseCase;

    private final AuthLoginUseCase loginUseCase;

    public User register(RegisterUserDto registerUserDto) {
        return registerUseCase.handle(registerUserDto);
    }

    public JwtResponse login(LoginUserDto loginUserDto){
        return loginUseCase.handle(loginUserDto);
    }

}
