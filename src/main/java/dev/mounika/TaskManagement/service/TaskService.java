package dev.mounika.TaskManagement.service;

import dev.mounika.TaskManagement.dto.CreateTaskRequestDTO;
import dev.mounika.TaskManagement.dto.TaskResponseDTO;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponseDTO createTask(CreateTaskRequestDTO taskRequestDTO);
    List<TaskResponseDTO> getAllTasks(int userId);
//    TaskResponseDTO updateTask(UUID taskId, CreateTaskRequestDTO task);
//    boolean deleteTask(UUID taskId);
}
