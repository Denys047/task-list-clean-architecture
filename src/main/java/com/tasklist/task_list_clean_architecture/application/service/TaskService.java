package com.tasklist.task_list_clean_architecture.application.service;

import com.tasklist.task_list_clean_architecture.application.dto.request.CreateTaskDto;
import com.tasklist.task_list_clean_architecture.application.service.usercase.task.CreateTaskUseCase;
import com.tasklist.task_list_clean_architecture.application.service.usercase.task.QueryTaskUserCase;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TaskService {

    private final CreateTaskUseCase createTaskUseCase;

    private final QueryTaskUserCase queryTaskUserCase;

    public Task create(CreateTaskDto createTaskDto){
        return createTaskUseCase.handle(createTaskDto);
    }

//    public List<Task>

}
