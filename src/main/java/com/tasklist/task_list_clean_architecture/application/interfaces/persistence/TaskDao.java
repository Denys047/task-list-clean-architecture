package com.tasklist.task_list_clean_architecture.application.interfaces.persistence;

import com.tasklist.task_list_clean_architecture.domain.entity.Task;

public interface TaskDao {

    Task create(Task task);

}
