package dev.mounika.TaskManagement.dto;

import dev.mounika.TaskManagement.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String username;
    private String email;

    public static UserResponseDTO from(User user) {
        if(user == null) return null;
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.username= user.getUsername();

        return userResponseDTO;
    }

    public static User from(UserResponseDTO responseDTO) {
        return null;
    }
}
