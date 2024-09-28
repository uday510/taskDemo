package dev.mounika.TaskManagement.repository;

import dev.mounika.TaskManagement.entity.Task;
import dev.mounika.TaskManagement.entity.TaskStatus;
import dev.mounika.TaskManagement.entity.User;
import jakarta.annotation.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository

public interface TaskRepository extends JpaRepository<Task, UUID> {

    // Find tasks by the user entity
    List<Task> findByUser(UUID userId);

}

