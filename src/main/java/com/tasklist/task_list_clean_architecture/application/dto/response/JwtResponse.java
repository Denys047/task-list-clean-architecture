package com.tasklist.task_list_clean_architecture.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private UUID id;

    private String username;

    private String accessesToken;

    private String refreshToken;

}
