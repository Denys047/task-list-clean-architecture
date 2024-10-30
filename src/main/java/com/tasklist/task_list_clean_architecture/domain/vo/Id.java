package com.tasklist.task_list_clean_architecture.domain.vo;

import com.tasklist.task_list_clean_architecture.domain.exception.InvalidIdException;

import java.util.UUID;

public class Id {

    private final UUID id;

    public Id(UUID id) {
        if (id == null) {
            throw new InvalidIdException();
        }
        this.id = id;
    }

    public Id() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

}
