package dev.rynwllngtn.agorasystem.services.account;

import dev.rynwllngtn.agorasystem.dtos.account.AccountCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.account.AccountResponseDTO;
import dev.rynwllngtn.agorasystem.dtos.account.AccountUpdateRequestDTO;
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
    public AccountResponseDTO update(UUID id, AccountUpdateRequestDTO accountUpdateRequestDTO) {

        try {
            Account account = accountRepository.getReferenceById(id);
            account.update(accountUpdateRequestDTO.getBalance(),
                           accountUpdateRequestDTO.getTransferLimit(),
                           accountUpdateRequestDTO.getTransferLimitCap());

            accountRepository.save(account);
            return new AccountResponseDTO(account);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(Account.class, id);
        }
    }

    @Override
    public void delete(UUID id) {

        if (!accountRepository.existsById(id)) {
            throw new ResourceNotFoundException(Account.class, id);
        }

        accountRepository.deleteById(id);
    }

}