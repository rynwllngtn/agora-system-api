package dev.rynwllngtn.agorasystem.repositories.account;

import dev.rynwllngtn.agorasystem.entities.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}