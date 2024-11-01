package com.tasklist.task_list_clean_architecture.application.service.usercase.task;

import com.tasklist.task_list_clean_architecture.application.interfaces.persistence.TaskDao;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteTaskUseCase {

    private final TaskDao taskDao;

    public boolean handle(UUID id) {
        return taskDao.delete(id);
    }

}
