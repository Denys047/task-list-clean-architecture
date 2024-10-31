package com.tasklist.task_list_clean_architecture.application.dto.validation.validator;

import com.tasklist.task_list_clean_architecture.application.consts.Status;
import com.tasklist.task_list_clean_architecture.application.dto.validation.annotation.TaskStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaskStatusValidator implements ConstraintValidator<TaskStatus, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals(Status.DONE.getStatus()) ||
                        value.equals(Status.TODO.getStatus()) ||
                        value.equals(Status.IN_PROGRESS.getStatus());
    }

}
