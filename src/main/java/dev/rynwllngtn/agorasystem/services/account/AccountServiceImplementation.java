package dev.rynwllngtn.agorasystem.services.account;

import dev.rynwllngtn.agorasystem.entities.account.Account;
import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.repositories.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImplementation implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(UUID id) {
        Optional<Account> user = accountRepository.findById(id);
        return user.get();
    }

    @Override
    public Account insert(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(UUID id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account update(UUID id, Account accountData) {
        Account account = accountRepository.getReferenceById(id);
        updateData(account, accountData);
        return accountRepository.save(account);
    }

    private void updateData(Account account, Account accountData) {
        account.setBalance(accountData.getBalance());
        account.setTransferLimit(accountData.getTransferLimit());
        account.setTransferLimitCap(accountData.getTransferLimitCap());
    }

}