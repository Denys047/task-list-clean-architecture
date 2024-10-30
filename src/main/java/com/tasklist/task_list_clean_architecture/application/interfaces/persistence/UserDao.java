package com.tasklist.task_list_clean_architecture.application.interfaces.persistence;

import com.tasklist.task_list_clean_architecture.domain.entity.User;


public interface UserDao {

    User create(User user);

    boolean existByUsername(String username);

}
