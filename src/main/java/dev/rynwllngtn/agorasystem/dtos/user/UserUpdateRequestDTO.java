package dev.rynwllngtn.agorasystem.dtos.user;

import dev.rynwllngtn.agorasystem.enums.user.UserStatus;

import java.time.LocalDate;

public record UserUpdateRequestDTO(
        String password,
        String userName,
        LocalDate birthDate,
        UserStatus status
) {}