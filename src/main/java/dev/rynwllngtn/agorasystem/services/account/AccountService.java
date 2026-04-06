package dev.rynwllngtn.agorasystem.services.account;

import dev.rynwllngtn.agorasystem.dtos.account.AccountCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.account.AccountResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.account.AccountUpdateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.account.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountService {

    Account findById(UUID id);
    AccountResponseDTO findResponseById(UUID id);

    Account insert(AccountCreateRequestDTO accountCreateRequestDTO);

    AccountResponseDTO update(UUID id, AccountUpdateRequestDTO accountUpdateRequestDTO);

    void delete(UUID id);

}