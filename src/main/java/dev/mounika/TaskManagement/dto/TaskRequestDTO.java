package dev.mounika.TaskManagement.dto;

import dev.mounika.TaskManagement.entity.Priority;
import dev.mounika.TaskManagement.entity.TaskStatus;
import dev.mounika.TaskManagement.entity.User;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

public class TaskRequestDTO {
    private String Title;
    private String Description;
    private TaskStatus status;
    private Priority priority;
    private Instant duedate;
    private UUID userid;
}
