package com.tasklist.task_list_clean_architecture.domain.entity;

import com.tasklist.task_list_clean_architecture.domain.vo.DateRange;
import com.tasklist.task_list_clean_architecture.domain.vo.Id;

import java.time.LocalDate;
import java.util.UUID;

public class Task {

    private Id id;

    private String title;

    private String description;

    private String statusType;

    private DateRange dateRange;

    public Task(Id id, String title, String description, String statusType, DateRange dateRange) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.statusType = statusType;
        this.dateRange = dateRange;
    }

    public UUID getId() {
        return id.getId();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusType() {
        return statusType;
    }

    public LocalDate getDateStart() {
        return dateRange.getDateStart();
    }

    public LocalDate getDateEnd() {
        return dateRange.getDateEnd();
    }

}
