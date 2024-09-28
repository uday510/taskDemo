package dev.mounika.TaskManagement.dto;

import dev.mounika.TaskManagement.entity.TaskPriority;
import dev.mounika.TaskManagement.entity.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public class TaskRequestDTO {
    private String Title;
    private String Description;
    private TaskStatus status;
    private TaskPriority taskPriority;
    private Instant duedate;
    private int userID;
}
