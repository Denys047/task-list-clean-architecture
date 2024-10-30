package com.tasklist.task_list_clean_architecture.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    private String username;

    private String name;

    private String password;

    private String repeatablePassword;

}
