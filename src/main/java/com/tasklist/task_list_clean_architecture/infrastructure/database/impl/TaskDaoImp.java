package com.tasklist.task_list_clean_architecture.infrastructure.database.impl;

import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.TaskOrm;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TaskDaoImp implements TaskDao {

    private final TaskOrm taskOrm;

    @Override
    public Task create(Task task) {
        return null;
    }

    @Override
    public List<Task> findAllTaskByUserId(UUID id) {
        return List.of();
    }

}
