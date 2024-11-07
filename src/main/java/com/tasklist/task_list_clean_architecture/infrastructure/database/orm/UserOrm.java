package com.tasklist.task_list_clean_architecture.infrastructure.database.orm;

import com.tasklist.task_list_clean_architecture.infrastructure.database.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserOrm extends JpaRepository<UserModel, UUID> {

    @Query("""
            SELECT COUNT(u) > 0 FROM UserModel u
            WHERE u.username = :username
            """)
    boolean existByUsername(@Param("username") String username);

    Optional<UserModel> findUserModelByUsername(String username);

}
