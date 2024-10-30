package com.tasklist.task_list_clean_architecture.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskDto {

    private String title;

    private String description;

    private String statusType;

    private LocalDate dateStart;

    private LocalDate dateEnd;

}
