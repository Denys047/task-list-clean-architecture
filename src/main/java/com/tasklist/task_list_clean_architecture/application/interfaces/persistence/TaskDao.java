package com.tasklist.task_list_clean_architecture.application.interfaces.persistence;

import com.tasklist.task_list_clean_architecture.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskDao {

    Task create(Task task);

    List<Task> findAllTaskByUserId(UUID id);

}
