package com.tasklist.task_list_clean_architecture.infrastructure.database.model;

import com.tasklist.task_list_clean_architecture.application.consts.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    private UUID id;

    private String name;

    private String username;

    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany
    private List<TaskModel> taskModels = new ArrayList<>();

}
