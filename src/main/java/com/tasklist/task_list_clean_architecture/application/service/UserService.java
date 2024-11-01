package com.tasklist.task_list_clean_architecture.application.service;

import com.tasklist.task_list_clean_architecture.application.dto.request.UpdateUserDto;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.DeleteUserUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.GetByIdUserUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.IsTaskOwnerUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.user.UpdateUserUseCase;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UserService {

    private final GetByIdUserUseCase getByIdUserUseCase;

    private final IsTaskOwnerUseCase isTaskOwnerUseCase;

    private final UpdateUserUseCase updateUserUseCase;

    private final DeleteUserUseCase deleteUserUseCase;

    public User getById(UUID id) {
        return getByIdUserUseCase.handle(id);
    }

    public boolean isTaskOwner(UUID userId, UUID taskId) {
        return isTaskOwnerUseCase.handle(userId, taskId);
    }

    public User update(UUID id, UpdateUserDto updateUserDto) {
        return updateUserUseCase.handle(id, updateUserDto);
    }

    public boolean delete(UUID id) {
        return deleteUserUseCase.handle(id);
    }

}
