package com.tasklist.task_list_clean_architecture.presentation.api;

import com.tasklist.task_list_clean_architecture.application.dto.response.ApiResponse;
import com.tasklist.task_list_clean_architecture.application.dto.response.ReadUserDto;
import com.tasklist.task_list_clean_architecture.application.dto.response.ReadUserTasksDto;
import com.tasklist.task_list_clean_architecture.application.dto.response.ReadUserWithTasksDto;
import com.tasklist.task_list_clean_architecture.application.service.TaskService;
import com.tasklist.task_list_clean_architecture.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ReadUserDto>> getById(@PathVariable("id") UUID id) {
        var result = userService.getById(id);
        return ResponseEntity.ok(new ApiResponse<>(
                List.of(new ReadUserDto(
                        result.getId().toString(),
                        result.getName(),
                        result.getUsername()
                ))
        ));
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<ApiResponse<ReadUserTasksDto>> getTasksByUserId(@PathVariable("id") UUID id) {
        return null;
    }
}
