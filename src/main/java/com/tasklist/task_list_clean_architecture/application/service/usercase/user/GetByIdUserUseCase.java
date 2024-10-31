package com.tasklist.task_list_clean_architecture.application.service.usercase.user;

import com.tasklist.task_list_clean_architecture.application.exception.ResourceNotFoundException;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GetByIdUserUseCase {

    private final UserDao userDao;

    public User handle(UUID id) {
        return userDao.
                findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
