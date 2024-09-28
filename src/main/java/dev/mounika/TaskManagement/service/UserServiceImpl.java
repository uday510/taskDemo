package dev.mounika.TaskManagement.service;

import dev.mounika.TaskManagement.dto.UserResponseDTO;
import dev.mounika.TaskManagement.dto.LoginRequestDTO;
import dev.mounika.TaskManagement.dto.RegisterRequestDTO;
import dev.mounika.TaskManagement.entity.User;
import dev.mounika.TaskManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

  //  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

//    public void register(RegisterRequestDTO registerRequestDTO) {
//        User user = new User();
//        user.setUsername(registerRequestDTO.getUsername());
//        user.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
//        userRepository.save(user);
//    }

    @Override
    public UserResponseDTO register(RegisterRequestDTO  registerRequestDTO)  {
        User user = new User();
        user.setUsername(registerRequestDTO.getUsername());
  //      user.setPassword(encoder.encode(registerRequestDTO.getPassword()));
        user.setPassword(registerRequestDTO.getPassword());
        user= userRepository.save(user);
        return UserResponseDTO.getUser(user);

    }

    @Override
    public UserResponseDTO login(LoginRequestDTO loginRequestDTO) {
        return null;
    }


}
