package com.tasklist.task_list_clean_architecture.application.service;

import com.tasklist.task_list_clean_architecture.application.dto.request.RegisterUserDto;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.RegisterUserUseCase;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final RegisterUserUseCase registerUserUseCase;

    public User register(RegisterUserDto registerUserDto){
        return registerUserUseCase.handle(registerUserDto);
    }

}
