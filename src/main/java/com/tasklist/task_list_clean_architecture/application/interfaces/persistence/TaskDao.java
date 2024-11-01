package com.tasklist.task_list_clean_architecture.application.interfaces.persistence;

import com.tasklist.task_list_clean_architecture.domain.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskDao {

    Task create(Task task);

    Optional<Task> findById(UUID id);

    List<Task> findAllByUserId(UUID id);

    Task update(Task task);

    boolean delete(UUID id);

}
