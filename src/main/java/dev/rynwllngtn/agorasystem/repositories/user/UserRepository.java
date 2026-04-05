package dev.rynwllngtn.agorasystem.repositories.user;

import dev.rynwllngtn.agorasystem.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}