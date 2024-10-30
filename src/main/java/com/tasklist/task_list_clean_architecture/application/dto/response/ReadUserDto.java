package com.tasklist.task_list_clean_architecture.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadUserDto {

    private String id;

    private String name;

    private String username;

}
