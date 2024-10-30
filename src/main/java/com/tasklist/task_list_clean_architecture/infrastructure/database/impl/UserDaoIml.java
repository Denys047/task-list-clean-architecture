package com.tasklist.task_list_clean_architecture.infrastructure.database.impl;

import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.UserDao;
import com.tasklist.task_list_clean_architecture.domain.entity.User;
import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.UserOrm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDaoIml implements UserDao {

    private final UserOrm userOrm;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public boolean existByUsername(String username) {
        return false;
    }

}
