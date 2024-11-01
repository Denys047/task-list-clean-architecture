package com.tasklist.task_list_clean_architecture.application.service;

import com.tasklist.task_list_clean_architecture.application.dto.request.CreateTaskDto;
import com.tasklist.task_list_clean_architecture.application.service.usercase.task.CreateTaskUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.task.GetAllTaskByUserId;
import com.tasklist.task_list_clean_architecture.application.service.usercase.task.GetByIdTaskUseCase;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class TaskService {

    private final CreateTaskUseCase createTaskUseCase;

    private final GetByIdTaskUseCase getByIdTaskUseCase;

    private final GetAllTaskByUserId getAllTaskByUserId;

    public Task create(CreateTaskDto createTaskDto) {
        return createTaskUseCase.handle(createTaskDto);
    }

    public Task getById(UUID id) {
        return getByIdTaskUseCase.handle(id);
    }

    public List<Task> getAllByUserId(UUID id) {
        return getAllTaskByUserId.handle(id);
    }

}
