package com.tasklist.task_list_clean_architecture.infrastructure.database.impl;

import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import com.tasklist.task_list_clean_architecture.infrastructure.database.orm.TaskOrm;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TaskDaoImp implements TaskDao {

    private final TaskOrm taskOrm;

    @Override
    public Task create(Task task) {
        return null;
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUserId(UUID id) {
        return List.of();
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

}
