package dev.mounika.TaskManagement.service;

import dev.mounika.TaskManagement.dto.CreateTaskRequestDTO;
import dev.mounika.TaskManagement.dto.TaskResponseDTO;
import dev.mounika.TaskManagement.entity.TaskStatus;
import dev.mounika.TaskManagement.entity.TaskPriority;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponseDTO createTask(CreateTaskRequestDTO taskRequestDTO);

    TaskResponseDTO updateTask(UUID taskId, CreateTaskRequestDTO task);

    Boolean deleteTask(UUID taskId);

    List<TaskResponseDTO> getAllTasks(UUID userId);
//    boolean deleteTask(UUID taskId);
    List<TaskResponseDTO> searchTasks(String keyword);
    List<TaskResponseDTO>  filterTasks(TaskStatus status, TaskPriority priority, LocalDate dueDate);

}
