package com.tasklist.task_list_clean_architecture.application.service;

import com.tasklist.task_list_clean_architecture.application.dto.request.CreateTaskDto;
import com.tasklist.task_list_clean_architecture.application.dto.request.UpdateTaskDto;
import com.tasklist.task_list_clean_architecture.application.service.usercase.task.*;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TaskService {

    private final CreateTaskUseCase createTaskUseCase;

    private final GetByIdTaskUseCase getByIdTaskUseCase;

    private final GetAllTaskByUserId getAllTaskByUserId;

    private final UpdateTaskUseCase updateTaskUseCase;

    private final DeleteTaskUseCase deleteTaskUseCase;

    public Task create(CreateTaskDto createTaskDto) {
        return createTaskUseCase.handle(createTaskDto);
    }

    public Task getById(UUID id) {
        return getByIdTaskUseCase.handle(id);
    }

    public List<Task> getAllByUserId(UUID id) {
        return getAllTaskByUserId.handle(id);
    }

    public Task update(UUID id, UpdateTaskDto updateTaskDto) {
        return updateTaskUseCase.handle(id, updateTaskDto);
    }

    public boolean delete(UUID id) {
        return deleteTaskUseCase.handle(id);
    }

}
