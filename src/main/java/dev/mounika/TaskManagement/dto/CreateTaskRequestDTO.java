package dev.mounika.TaskManagement.dto;

import dev.mounika.TaskManagement.entity.Priority;
import dev.mounika.TaskManagement.entity.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;
@Getter
@Setter
public class CreateTaskRequestDTO {
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private Instant duedate;
    private int userID;
}
