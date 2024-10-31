package com.tasklist.task_list_clean_architecture.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    @NotEmpty(message = "Username must not be empty.")
    private String username;

    @NotEmpty(message = "Name must not be empty.")
    private String name;

    @NotEmpty(message = "Password must not be empty.")
    private String password;

    @NotEmpty(message = "Repeatable password must not be empty.")
    private String repeatablePassword;

}
