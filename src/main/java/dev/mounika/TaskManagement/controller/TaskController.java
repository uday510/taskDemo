package dev.mounika.TaskManagement.controller;

import dev.mounika.TaskManagement.dto.CreateTaskRequestDTO;
import dev.mounika.TaskManagement.dto.TaskResponseDTO;
import dev.mounika.TaskManagement.entity.TaskPriority;
import dev.mounika.TaskManagement.entity.TaskStatus;
import dev.mounika.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/{userId}")
    public ResponseEntity<List<TaskResponseDTO>> getAllTasksByUser(@PathVariable UUID userId) {
        List<TaskResponseDTO> tasks = taskService.getAllTasks(userId);
        return ResponseEntity.ok(tasks);
    }

    // Update a task
    @PatchMapping("/{taskId}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable UUID taskId, @RequestBody CreateTaskRequestDTO taskDetails) {
        return ResponseEntity.ok(taskService.updateTask(taskId, taskDetails));
    }

    // Delete a task
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable UUID taskId) {
        return ResponseEntity.ok(taskService.deleteTask(taskId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<TaskResponseDTO>> searchTasks(@RequestParam("keyword") String keyword) {
        return ResponseEntity.ok(taskService.searchTasks(keyword));
    }
    @GetMapping("/filter")
    public ResponseEntity<List<TaskResponseDTO>> filterTasks(
            @RequestParam(value = "status", required = false) TaskStatus status,
            @RequestParam(value = "priority", required = false) TaskPriority priority,
            @RequestParam(value = "dueDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dueDate) {
        return ResponseEntity.ok(taskService.filterTasks(status, priority, dueDate));
    }
    public static UUID hexToUUID(String hex) {
        if (hex.startsWith("0x")) {
            hex = hex.substring(2);
        }
        // Ensure the length is correct for UUID
        if (hex.length() != 32) {
            throw new IllegalArgumentException("Invalid hex string length for UUID");
        }

        // Convert to bytes
        byte[] bytes = new byte[16];
        for (int i = 0; i < 16; i++) {
            bytes[i] = (byte) ((Character.digit(hex.charAt(i * 2), 16) << 4)
                    + Character.digit(hex.charAt(i * 2 + 1), 16));
        }

        return UUID.nameUUIDFromBytes(bytes);
    }
}