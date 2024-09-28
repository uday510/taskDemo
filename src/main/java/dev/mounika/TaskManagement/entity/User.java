package dev.mounika.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String username;
    private String password;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String role = "USER";
}