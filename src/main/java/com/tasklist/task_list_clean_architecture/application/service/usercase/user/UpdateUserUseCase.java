package com.tasklist.task_list_clean_architecture.application.service.usercase.user;

import com.tasklist.task_list_clean_architecture.application.dto.request.UpdateUserDto;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import com.tasklist.task_list_clean_architecture.domain.vo.Id;
import com.tasklist.task_list_clean_architecture.domain.vo.Password;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateUserUseCase {

    private final UserDao userDao;

    public User handle(UUID id, UpdateUserDto updateUserDto) {
        return userDao
                .findById(id)
                .map(user -> {
                    var result = new User(
                            new Id(user.getId()),
                            updateUserDto.getName(),
                            user.getUsername(),
                            new Password(user.getPassword()),
                            user.getRoleType(),
                            user.getTasks()
                    );
                    userDao.update(result);
                    return result;
                }).orElseThrow();
    }

}

