package dev.rynwllngtn.daos.account;

import dev.rynwllngtn.entities.account.Account;

import java.util.List;
import java.util.UUID;

public interface AccountDao {

    void insert(Account account);
    void update(Account account);
    void deleteById(UUID id);
    Account findById(UUID id);
    List<Account> findAll();

}