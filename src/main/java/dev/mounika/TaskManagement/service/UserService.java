package dev.mounika.TaskManagement.service;

import dev.mounika.TaskManagement.dto.UserResponseDTO;
import dev.mounika.TaskManagement.dto.LoginRequestDTO;
import dev.mounika.TaskManagement.dto.RegisterRequestDTO;

public interface UserService {
    UserResponseDTO register(RegisterRequestDTO singUpRequestDTO);
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);
}
