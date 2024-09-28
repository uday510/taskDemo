package dev.mounika.TaskManagement.controller;

import dev.mounika.TaskManagement.dto.LoginRequestDTO;
import dev.mounika.TaskManagement.dto.RegisterRequestDTO;
import dev.mounika.TaskManagement.entity.User;
import dev.mounika.TaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/SingUp")
    public ResponseEntity<String> register(@RequestBody RegisterRequestDTO signUpRequestDTO) {
        userService.register(signUpRequestDTO);
        return ResponseEntity.ok("User registered successfully");
    }
//
//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody LoginRequestDTO loginRequestDTO) {
//        return ResponseEntity.ok(userService.login(loginRequestDTO));
//
//    }

}
