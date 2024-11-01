package com.tasklist.task_list_clean_architecture.application.interfaces.persistence;

import com.tasklist.task_list_clean_architecture.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserDao {

    User create(User user);

    boolean existByUsername(String username);

    Optional<User> findById(UUID id);

    void update(User user);

    boolean isTaskOwner(UUID userId, UUID taskId);

    boolean delete(UUID id);

}
