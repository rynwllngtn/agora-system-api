package dev.rynwllngtn.agorasystem.services.user;

import dev.rynwllngtn.agorasystem.dtos.user.UserCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.user.UserResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.user.UserUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ResourceNotFoundException;
import dev.rynwllngtn.agorasystem.repositories.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(User.class, id));
    }

    @Override
    public User findReferenceById(UUID id) {
        try {
            return userRepository.getReferenceById(id);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(User.class, id);
        }
    }

    @Override
    public UserResponseDTO findResponseById(UUID id) {
        Optional<UserResponseDTO> userResponseDTO = userRepository.findResponseById(id);
        return userResponseDTO.orElseThrow(() -> new ResourceNotFoundException(User.class, id));
    }

    @Override
    public User insert(UserCreateRequestDTO createRequestDTO) {
        User user = new User(createRequestDTO.cpf(),
                             createRequestDTO.password(),
                             createRequestDTO.userName(),
                             createRequestDTO.birthDate());

        return userRepository.save(user);
    }

    @Override
    public User update(UUID id, UserUpdateRequestDTO updateRequestDTO) {
        try {
            User user = userRepository.getReferenceById(id);
            user.update(updateRequestDTO.password(),
                        updateRequestDTO.userName(),
                        updateRequestDTO.birthDate(),
                        updateRequestDTO.status());

            return userRepository.save(user);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(User.class, id);
        }

    }

    @Override
    public User deactivate(UUID id) {
        try {
            User user = userRepository.getReferenceById(id);
            user.deactivate();
            return userRepository.save(user);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(User.class, id);
        }
    }

    @Override
    public User reactivate(UUID id) {
        try {
            User user = userRepository.getReferenceById(id);
            user.reactivate();
            return userRepository.save(user);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(User.class, id);
        }
    }

}