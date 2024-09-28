package dev.mounika.TaskManagement.controller;


import dev.mounika.TaskManagement.dto.LoginRequestDTO;
import dev.mounika.TaskManagement.dto.RegisterRequestDTO;

import dev.mounika.TaskManagement.dto.UserResponseDTO;
import dev.mounika.TaskManagement.entity.User;
import dev.mounika.TaskManagement.service.JwtService;
import dev.mounika.TaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterRequestDTO signUpRequestDTO) {
        return ResponseEntity.ok(userService.register(signUpRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequestDTO loginRequestDTO){
        UserResponseDTO userResponseDTO = userService.login(loginRequestDTO);

        String token = jwtService.generateAccessToken(userResponseDTO);

        Map<String, String> response = Map.of("token", token);

        return ResponseEntity.ok(response);
    }
}
