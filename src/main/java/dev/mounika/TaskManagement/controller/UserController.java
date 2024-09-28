package dev.mounika.TaskManagement.controller;


import dev.mounika.TaskManagement.dto.RegisterRequestDTO;

import dev.mounika.TaskManagement.dto.UserResponseDTO;
import dev.mounika.TaskManagement.entity.User;
import dev.mounika.TaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterRequestDTO signUpRequestDTO) {
        return ResponseEntity.ok(userService.register(signUpRequestDTO));
    }
//
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody LoginRequestDTO loginRequestDTO) {
//        return ResponseEntity.ok(userService.login(loginRequestDTO));
//
//    }

}
