package dev.rynwllngtn.agorasystem.services.account;

import dev.rynwllngtn.agorasystem.entities.account.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AccountService {

    public List<Account> findAll();

    public Account findById(UUID id);

    public Account insert(Account account);

    public void delete(UUID id);

    public Account update(UUID id, Account accountData);

}