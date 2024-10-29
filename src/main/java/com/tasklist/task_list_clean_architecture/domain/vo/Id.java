package com.tasklist.task_list_clean_architecture.domain.vo;

import com.tasklist.task_list_clean_architecture.domain.exception.InvalidIdException;

import java.util.UUID;

public class Id {

    private final UUID value;

    public Id(UUID value) {
        if (value == null) {
            throw new InvalidIdException();
        }
        this.value = value;
    }

    public Id() {
        this.value = UUID.randomUUID();
    }

    public UUID getValue() {
        return value;
    }

}
