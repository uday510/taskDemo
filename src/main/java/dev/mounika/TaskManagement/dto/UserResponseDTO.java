package dev.mounika.TaskManagement.dto;

import dev.mounika.TaskManagement.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserResponseDTO {
    private int id;
    private String username;

    public static UserResponseDTO getUser(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        return userResponseDTO;
    }
}
