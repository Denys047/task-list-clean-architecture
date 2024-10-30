package com.tasklist.task_list_clean_architecture.application.service.usercase.task;

import com.tasklist.task_list_clean_architecture.application.consts.Status;
import com.tasklist.task_list_clean_architecture.application.dto.request.CreateTaskDto;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import com.tasklist.task_list_clean_architecture.domain.vo.DateRange;
import com.tasklist.task_list_clean_architecture.domain.vo.Id;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateTaskUseCase {

    private final TaskDao taskDao;

    public Task handle(CreateTaskDto createTaskDto) {
        return taskDao.create(new Task(
                new Id(),
                createTaskDto.getTitle(),
                createTaskDto.getDescription(),
                Status.fromString(createTaskDto.getStatusType()).getStatus(),
                new DateRange(createTaskDto.getDateStart(), createTaskDto.getDateEnd())
        ));
    }

}
