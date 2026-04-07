package dev.rynwllngtn.agorasystem.services.account;

import dev.rynwllngtn.agorasystem.dtos.account.*;
import dev.rynwllngtn.agorasystem.entities.account.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountService {

    Account findById(UUID id);
    AccountResponseDTO findResponseById(UUID id);

    Account insert(AccountCreateRequestDTO accountCreateRequestDTO);

    Account deposit(UUID id, DepositRequestDTO depositRequestDTO);
    Account withdrawal(UUID id, WithdrawalRequestDTO withdrawalRequestDTO);

    void delete(UUID id);

}