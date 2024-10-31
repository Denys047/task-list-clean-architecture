package com.tasklist.task_list_clean_architecture.application.dto.request;

import com.tasklist.task_list_clean_architecture.application.dto.validation.annotation.TaskStatus;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDto {

    @NotEmpty(message = "Title can't be empty.")
    private String title;

    @NotEmpty(message = "Description can't be empty.")
    private String description;

    @NotEmpty(message = "Status cannot be empty. Please select a valid status.")
    @TaskStatus(message = "Invalid status. Accepted values: Todo, InProgress, or Done.")
    private String statusType;

    private LocalDate dateStart;

    private LocalDate dateEnd;

}
