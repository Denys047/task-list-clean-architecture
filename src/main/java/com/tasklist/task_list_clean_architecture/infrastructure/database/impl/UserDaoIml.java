package com.tasklist.task_list_clean_architecture.infrastructure.database.impl;

import com.tasklist.task_list_clean_architecture.application.consts.Role;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import com.tasklist.task_list_clean_architecture.infrastructure.database.model.UserModel;
import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.UserOrm;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

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
        return false;
    }

}
