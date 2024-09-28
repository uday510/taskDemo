package dev.mounika.TaskManagement.controller;

import dev.mounika.TaskManagement.dto.CreateTaskRequestDTO;
import dev.mounika.TaskManagement.dto.TaskResponseDTO;
import dev.mounika.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Create a new task
    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody CreateTaskRequestDTO createTaskRequestDTO) {
        return ResponseEntity.ok(taskService.createTask(createTaskRequestDTO));
    }

    // Get all tasks for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasksByUser(@PathVariable int userId) {
        List<TaskResponseDTO> tasks = taskService.getAllTasks(userId);
        return ResponseEntity.ok(tasks);
    }

//    // Update a task
//    @PutMapping("/update/{taskId}")
//    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable UUID taskId, @RequestBody CreateTaskRequestDTO taskDetails) {
//        return ResponseEntity.ok(taskService.updateTask(taskId,taskDetails));
//    }
//
//    // Delete a task
//    @DeleteMapping("/delete/{taskId}")
//    public ResponseEntity<Boolean> deleteTask(@PathVariable UUID taskId) {
//        return ResponseEntity.ok(taskService.deleteTask(taskId));
//    }
}