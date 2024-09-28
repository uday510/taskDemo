package dev.mounika.TaskManagement.service;

import dev.mounika.TaskManagement.dto.LoginRequestDTO;
import dev.mounika.TaskManagement.dto.RegisterRequestDTO;
import dev.mounika.TaskManagement.dto.UserResponseDTO;
import dev.mounika.TaskManagement.entity.User;
import dev.mounika.TaskManagement.repository.UserRepository;
import dev.mounika.TaskManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) { // Updated to PasswordEncoder
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO register(RegisterRequestDTO registerRequestDTO) {
        if (userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        user.setRole("ROLE_USER");
        user = userRepository.save(user);

        return UserResponseDTO.getUser(user);
    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Optional<User> user = userRepository.findByUsername(loginRequestDTO.getUsername());

        if (user.isPresent() && passwordEncoder.matches(loginRequestDTO.getPassword(), user.get().getPassword())) {
            return UserResponseDTO.getUser(user.get());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @Override
    public UserResponseDTO getUser(UUID id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return UserResponseDTO.getUser(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public UserResponseDTO getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return UserResponseDTO.getUser(user.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
