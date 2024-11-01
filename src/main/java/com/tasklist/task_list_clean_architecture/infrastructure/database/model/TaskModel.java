package com.tasklist.task_list_clean_architecture.infrastructure.database.model;

import com.tasklist.task_list_clean_architecture.application.consts.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;

}
