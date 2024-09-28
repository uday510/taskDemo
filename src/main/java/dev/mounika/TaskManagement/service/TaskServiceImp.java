package dev.mounika.TaskManagement.service;

import dev.mounika.TaskManagement.dto.CreateTaskRequestDTO;
import dev.mounika.TaskManagement.dto.TaskResponseDTO;
import dev.mounika.TaskManagement.entity.Task;
import dev.mounika.TaskManagement.entity.User;
import dev.mounika.TaskManagement.exception.TaskNotFoundException;
import dev.mounika.TaskManagement.mapper.TaskEntityDTOMapper;
import dev.mounika.TaskManagement.repository.TaskRepository;
import dev.mounika.TaskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TaskResponseDTO createTask(CreateTaskRequestDTO taskRequestDTO) {
        // Find the user by userId
        Optional<User> userOptional = userRepository.findById(taskRequestDTO.getUserId());

        if (userOptional.isPresent()) {
            // Create a new Task entity from the request DTO
            Task task = new Task();
            task.setTitle(taskRequestDTO.getTitle());
            task.setDescription(taskRequestDTO.getDescription());
            task.setStatus(taskRequestDTO.getStatus());
            task.setPriority(taskRequestDTO.getPriority());
            task.setDueDate(taskRequestDTO.getDuedate());
            task.setUserid(taskRequestDTO.getUserId());

            // Save the task to the repository
            Task savedTask = taskRepository.save(task);
            return TaskEntityDTOMapper.convertTaskEntityToTaskResponseDTO(savedTask);
        } else {
            throw new RuntimeException("User not found");
        }
    }
//
//    @Override
//    public List<TaskResponseDTO> getAllTasks(UUID userId) {
//        // Fetch the user first to ensure they exist
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        // Fetch tasks by the user
//        List<Task> tasks = taskRepository.findByUser(userId);
//        List<TaskResponseDTO> taskResponseDTOS = new ArrayList<>();
//
//        for (Task task : tasks) {
//            taskResponseDTOS.add(TaskEntityDTOMapper.convertTaskEntityToTaskResponseDTO(task));
//        }
//        return taskResponseDTOS;
//    }
//
//    @Override
//    public TaskResponseDTO updateTask(UUID taskId, CreateTaskRequestDTO taskRequestDTO) {
//        Task savedTask = taskRepository.findById(taskId)
//                .orElseThrow(() -> new TaskNotFoundException("Task not found for id " + taskId));
//
//        savedTask.setTitle(taskRequestDTO.getTitle());
//        savedTask.setDescription(taskRequestDTO.getDescription());
//        savedTask.setStatus(taskRequestDTO.getStatus());
//        savedTask.setPriority(taskRequestDTO.getPriority());
//        savedTask.setDueDate(taskRequestDTO.getDuedate());
//        // No need to set userid; it's already linked through User
//
//        savedTask = taskRepository.save(savedTask);
//        return TaskEntityDTOMapper.convertTaskEntityToTaskResponseDTO(savedTask);
//    }
//
//    @Override
//    public boolean deleteTask(UUID taskId) {
//        if (!taskRepository.existsById(taskId)) {
//            throw new TaskNotFoundException("Task not found for id " + taskId);
//        }
//        taskRepository.deleteById(taskId);
//        return true;
//    }
}
