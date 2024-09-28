package dev.mounika.TaskManagement.mapper;

import dev.mounika.TaskManagement.dto.TaskResponseDTO;
import dev.mounika.TaskManagement.entity.Task;
import dev.mounika.TaskManagement.entity.TaskStatus;

public class TaskEntityDTOMapper {

    public static TaskResponseDTO convertCreateTaskRequestDTOToTask(Task task) {
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setTitle(task.getTitle());
        taskResponseDTO.setDescription(task.getDescription());
        taskResponseDTO.setStatus(TaskStatus.IN_PROGRESS);
        taskResponseDTO.setTaskPriority(task.getTaskPriority());
        taskResponseDTO.setDuedate(task.getDueDate());
        taskResponseDTO.setUserID(task.getUser().getId());
        return taskResponseDTO;
    }
    public static TaskResponseDTO convertTaskEntityToTaskResponseDTO(Task task) {
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setTitle(task.getTitle());
        taskResponseDTO.setDescription(task.getDescription());
        taskResponseDTO.setStatus(TaskStatus.IN_PROGRESS);
        taskResponseDTO.setTaskPriority(task.getTaskPriority());
        taskResponseDTO.setDuedate(task.getDueDate());
        taskResponseDTO.setUserID(task.getUser().getId());
        return taskResponseDTO;
    }


}
