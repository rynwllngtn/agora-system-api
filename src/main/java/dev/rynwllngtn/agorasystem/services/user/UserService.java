package dev.rynwllngtn.agorasystem.services.user;

import dev.rynwllngtn.agorasystem.dtos.user.UserCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.user.UserResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.user.UserUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {

    User findById(UUID id);
    User findReferenceById(UUID id);
    UserResponseDTO findResponseById(UUID id);

    User insert(UserCreateRequestDTO userCreateRequestDTO);

    UserResponseDTO update(UUID id, UserUpdateRequestDTO userUpdateRequestDTO);

    void delete(UUID id);

}