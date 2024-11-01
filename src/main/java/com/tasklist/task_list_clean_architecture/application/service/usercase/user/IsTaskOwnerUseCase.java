package com.tasklist.task_list_clean_architecture.application.service.usercase.user;

import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class IsTaskOwnerUseCase {

    private final UserDao userDao;

    public boolean handle(UUID userId, UUID taskId) {
        return userDao.isTaskOwner(userId, taskId);
    }

}
