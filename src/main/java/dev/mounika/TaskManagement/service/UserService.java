package dev.mounika.TaskManagement.service;

import dev.mounika.TaskManagement.dto.UserResponseDTO;
import dev.mounika.TaskManagement.dto.LoginRequestDTO;
import dev.mounika.TaskManagement.dto.RegisterRequestDTO;

import java.util.UUID;

public interface UserService {
    UserResponseDTO register(RegisterRequestDTO singUpRequestDTO);
    UserResponseDTO login(LoginRequestDTO loginRequestDTO);

    UserResponseDTO getUser(UUID id);

    UserResponseDTO getUserByUsername(String username);

}
