package com.tasklist.task_list_clean_architecture.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadTaskDto {

    private String id;

    private String title;

    private String description;

    private String statusType;

    private LocalDate dateStart;

    private LocalDate dateEnd;

}
