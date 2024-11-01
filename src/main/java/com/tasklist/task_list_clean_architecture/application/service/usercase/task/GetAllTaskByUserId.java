package com.tasklist.task_list_clean_architecture.application.service.usercase.task;

import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import com.tasklist.task_list_clean_architecture.domain.entity.Task;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class GetAllTaskByUserId {

    private final TaskDao taskDao;

    public List<Task> handle(UUID id) {
        return taskDao.findAllByUserId(id);
    }

}
