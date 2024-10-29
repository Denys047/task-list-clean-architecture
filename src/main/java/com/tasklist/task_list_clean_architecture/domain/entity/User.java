package com.tasklist.task_list_clean_architecture.domain.entity;

import com.tasklist.task_list_clean_architecture.domain.vo.Id;

import java.util.UUID;

public class User {

    private Id id;


    public UUID getId() {
        return id.getValue();
    }

}
