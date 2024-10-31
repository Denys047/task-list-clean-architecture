package com.tasklist.task_list_clean_architecture.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDto {

    @NotEmpty(message = "Username must not be empty.")
    private String username;

    @NotEmpty(message = "Password must not be empty.")
    private String password;

}
