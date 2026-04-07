package dev.rynwllngtn.agorasystem.services.account;

import dev.rynwllngtn.agorasystem.dtos.account.*;
import dev.rynwllngtn.agorasystem.entities.account.Account;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.*;
import dev.rynwllngtn.agorasystem.repositories.account.AccountRepository;
import dev.rynwllngtn.agorasystem.services.user.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Override
    public Account findById(UUID id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElseThrow(() -> new ResourceNotFoundException(Account.class, id));
    }

    @Override
    public AccountResponseDTO findResponseById(UUID id) {
        Optional<AccountResponseDTO> accountResponseDTO = accountRepository.findResponseById(id);
        return accountResponseDTO.orElseThrow(() -> new ResourceNotFoundException(Account.class, id));
    }

    @Override
    public Account insert(AccountCreateRequestDTO accountCreateRequestDTO) {

        Account account = accountCreateRequestDTO.getAccount();
        account.setHolder(userService.findReferenceById(accountCreateRequestDTO.getHolder()));
        return accountRepository.save(account);
    }

    @Override
    public Account deposit(UUID id, DepositRequestDTO depositRequestDTO) {

        Account account = accountRepository.getReferenceById(id);
        account.deposit(depositRequestDTO.amount());
        return accountRepository.save(account);
    }

    @Override
    public Account withdrawal(UUID id, WithdrawalRequestDTO withdrawalRequestDTO) {

        Account account = accountRepository.getReferenceById(id);
        account.withdrawal(withdrawalRequestDTO.amount());
        return accountRepository.save(account);
    }

    @Override
    public void delete(UUID id) {

        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException(Account.class, id);
        }

        accountRepository.deleteById(id);
    }

}