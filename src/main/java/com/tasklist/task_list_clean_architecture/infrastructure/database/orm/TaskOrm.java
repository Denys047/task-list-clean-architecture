package com.tasklist.task_list_clean_architecture.infrastructure.database.orm;

import com.tasklist.task_list_clean_architecture.infrastructure.database.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TaskOrm extends JpaRepository<TaskModel, UUID> {

    @Query("""
            SELECT t FROM TaskModel t
            WHERE t.user = :id
            """)
    List<TaskModel> findAllByUserId(@Param("id") UUID id);

}
