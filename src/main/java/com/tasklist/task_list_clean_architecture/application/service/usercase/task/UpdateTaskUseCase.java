package com.tasklist.task_list_clean_architecture.application.service.usercase.task;

import com.tasklist.task_list_clean_architecture.application.consts.Status;
import com.tasklist.task_list_clean_architecture.application.dto.request.UpdateTaskDto;
import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import com.tasklist.task_list_clean_architecture.domain.vo.DateRange;
import com.tasklist.task_list_clean_architecture.domain.vo.Id;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class UpdateTaskUseCase {

    private final TaskDao taskDao;

    public Task handle(UUID id, UpdateTaskDto updateTaskDto) {
        return taskDao
                .findById(id)
                .map(task -> {
                    var result = new Task(
                            new Id(task.getId()),
                            updateTaskDto.getTitle(),
                            updateTaskDto.getDescription(),
                            Status.fromString(updateTaskDto.getStatusType()).toString(),
                            new DateRange(updateTaskDto.getDateStart(), updateTaskDto.getDateEnd())
                    );
                    taskDao.update(result);
                    return result;
                })
                .orElseThrow();
    }

}
