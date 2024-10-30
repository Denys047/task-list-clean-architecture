package com.tasklist.task_list_clean_architecture.domain.vo;

public class Password {

    private final String hashPassword;

    public Password(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getPassword() {
        return hashPassword;
    }

}
