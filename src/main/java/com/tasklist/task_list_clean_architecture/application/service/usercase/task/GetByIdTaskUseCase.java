package com.tasklist.task_list_clean_architecture.application.service.usercase.task;

import com.tasklist.task_list_clean_architecture.application.exception.ResourceNotFoundException;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GetByIdTaskUseCase {

    private final TaskDao taskDao;

    public Task handle(UUID id) {
        return taskDao
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }

}