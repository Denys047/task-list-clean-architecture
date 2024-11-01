package com.tasklist.task_list_clean_architecture.application.dto.request;

import com.tasklist.task_list_clean_architecture.application.dto.validation.annotation.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskDto {

    private String title;

    private String description;

    @TaskStatus(message = "Invalid status. Accepted values: Todo, InProgress, or Done.")
    private String statusType;

    private LocalDate dateStart;

    private LocalDate dateEnd;

}
