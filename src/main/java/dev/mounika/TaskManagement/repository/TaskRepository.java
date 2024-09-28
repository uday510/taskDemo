package dev.mounika.TaskManagement.repository;

import dev.mounika.TaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Find tasks by user
    List<Task> findByUser(int user);

    // If you want to find by user ID, you can define it like this
    List<Task> findByUserId(int userId);
}
