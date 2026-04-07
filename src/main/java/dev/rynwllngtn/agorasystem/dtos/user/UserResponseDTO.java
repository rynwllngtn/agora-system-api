package dev.rynwllngtn.agorasystem.dtos.user;

import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.enums.user.UserStatus;

import java.time.LocalDate;

public record UserResponseDTO(
        String userName,
        LocalDate birthDate,
        UserStatus status
) {
    public UserResponseDTO(User user) {
        this(user.getUserName(),
             user.getBirthDate(),
             user.getStatus());
    }

}