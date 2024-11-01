package com.tasklist.task_list_clean_architecture.domain.entity;

import com.tasklist.task_list_clean_architecture.domain.vo.Id;
import com.tasklist.task_list_clean_architecture.domain.vo.Password;

import java.util.List;
import java.util.UUID;

public class User {

    private Id id;

    private String name;

    private String username;

    private Password password;

    private String roleType;

    private List<Task> tasks;

    public User(Id id, String name, String username, Password password, String roleType, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roleType = roleType;
        this.tasks = tasks;
    }

    public UUID getId() {
        return id.getId();
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password.getPassword();
    }

    public String getRoleType() {
        return roleType;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
