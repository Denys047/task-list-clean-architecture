package com.tasklist.task_list_clean_architecture.infrastructure.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class TaskModel {

    @Id
    private UUID id;

}
