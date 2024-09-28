package dev.mounika.TaskManagement.dto;

import dev.mounika.TaskManagement.entity.Priority;
import dev.mounika.TaskManagement.entity.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TaskResponseDTO {
    private String Title;
    private String Description;
    private TaskStatus status;
    private Priority priority;
    private Instant duedate;
    private int userID;
}
