package com.tasklist.task_list_clean_architecture.infrastructure.database.impl;

import com.tasklist.task_list_clean_architecture.application.consts.Role;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import com.tasklist.task_list_clean_architecture.infrastructure.database.model.UserModel;
import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.UserOrm;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserDaoIml implements UserDao {

    private final UserOrm userOrm;

    @Override
    public User create(User user) {
        UserModel userModel = new UserModel(user.getId(), user.getName(), user.getUsername(), user.getUsername(), Role.ROLE_USER, new ArrayList<>());
        userOrm.save(userModel);
        return user;
    }

    @Override
    public boolean existByUsername(String username) {
        return userOrm.existByUsername(username);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public boolean isTaskOwner(UUID userId, UUID taskId) {
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

}
