package dev.mounika.TaskManagement.repository;

import dev.mounika.TaskManagement.entity.Task;
import dev.mounika.TaskManagement.entity.TaskPriority;
import dev.mounika.TaskManagement.entity.TaskStatus;
import dev.mounika.TaskManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    // Find tasks by user
    List<Task> findByUser(User user);

    // If you want to find by user ID, you can define it like this
    List<Task> findByUserId(UUID userId);

    @Query("SELECT t FROM Task t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(t.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Task> searchTasksByTitleOrDescription(@Param("keyword") String keyword);

    @Query("SELECT t FROM Task t WHERE "
            + "(:status IS NULL OR t.status = :status) AND "
            + "(:priority IS NULL OR t.taskPriority = :priority) AND "
            + "(:dueDate IS NULL OR t.dueDate = :dueDate)")
    List<Task> filterTasks(@Param("status") TaskStatus status,
                           @Param("priority") TaskPriority priority,
                           @Param("dueDate") LocalDate dueDate);

}
