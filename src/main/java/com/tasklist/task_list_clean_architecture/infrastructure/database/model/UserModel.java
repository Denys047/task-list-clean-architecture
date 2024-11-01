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

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    private List<TaskModel> taskModels = new ArrayList<>();

    public void addTask(TaskModel taskModel) {
        this.taskModels.add(taskModel);
        taskModel.setUserModel(this);
    }

    public void deleteTask(TaskModel taskModel) {
        this.taskModels.remove(taskModel);
        taskModel.setUserModel(null);
    }

}
