package com.tasklist.task_list_clean_architecture.infrastructure.database.orm;

import com.tasklist.task_list_clean_architecture.infrastructure.database.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserOrm extends JpaRepository<UserModel, UUID> {

    @Query("""
            SELECT COUNT(u) > 0 FROM Users u
            WHERE u.username = :username
            """)
    boolean existByUsername(@Param("username") String username);

    @Query("""
            SELECT Users u FROM Users
            WHERE u.username = :username
            """)
    Optional<UserModel> findByUsername(@Param("username") String username);

}
