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

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Find tasks by user
    List<Task> findByUser(User user);

    // If you want to find by user ID, you can define it like this
    List<Task> findByUserId(int userId);
}
