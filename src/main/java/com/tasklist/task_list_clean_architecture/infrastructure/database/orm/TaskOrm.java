package com.tasklist.task_list_clean_architecture.infrastructure.database.orm;

import com.tasklist.task_list_clean_architecture.infrastructure.database.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskOrm extends JpaRepository<TaskModel, UUID> {



}
