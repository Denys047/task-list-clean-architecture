package com.tasklist.task_list_clean_architecture.presentation.api;

import com.tasklist.task_list_clean_architecture.application.dto.request.CreateTaskDto;
import com.tasklist.task_list_clean_architecture.application.dto.response.ApiResponse;
import com.tasklist.task_list_clean_architecture.application.dto.response.ReadTaskDto;
import com.tasklist.task_list_clean_architecture.application.dto.response.ReadUserDto;
import com.tasklist.task_list_clean_architecture.application.service.TaskService;
import com.tasklist.task_list_clean_architecture.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse<ReadTaskDto>> getTasksByUserId(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(
                new ApiResponse<>(
                        taskService.getAllByUserId(id)
                                .stream()
                                .map(it -> new ReadTaskDto(
                                        it.getId().toString(),
                                        it.getTitle(),
                                        it.getDescription(),
                                        it.getStatusType(),
                                        it.getDateStart(),
                                        it.getDateEnd()
                                ))
                                .toList()
                )
        );
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<ApiResponse<ReadTaskDto>> createTask(@PathVariable("id") UUID id, @Validated @RequestBody CreateTaskDto createTaskDto) {
        var result = taskService.create(createTaskDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(List.of(new ReadTaskDto(
                                result.getId().toString(),
                                result.getTitle(),
                                result.getDescription(),
                                result.getStatusType(),
                                result.getDateStart(),
                                result.getDateEnd()
                        )
                )));
    }

}
