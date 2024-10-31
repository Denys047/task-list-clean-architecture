package com.tasklist.task_list_clean_architecture.application.service;

import com.tasklist.task_list_clean_architecture.application.service.usercase.user.GetByIdUserUseCase;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UserService {

    private final GetByIdUserUseCase getByIdUserUseCase;

    public User getById(UUID id){
        return getByIdUserUseCase.handle(id);
    }

}
