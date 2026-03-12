package dev.rynwllngtn;

import dev.rynwllngtn.daos.DaoFactory;
import dev.rynwllngtn.daos.account.AccountDao;
import dev.rynwllngtn.daos.user.UserDao;
import dev.rynwllngtn.entities.account.Account;
import dev.rynwllngtn.entities.account.accounts.AccountChecking;
import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.utils.DatabaseUtil;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {

    static void main() {

        User newUser = new User("12312312312", "123123123");
        newUser.setId(UUID.randomUUID());
        Account newAccount = new AccountChecking(newUser);
        newAccount.setId(UUID.randomUUID());

        UserDao userDao = DaoFactory.createUserDao();
        AccountDao accountDao = DaoFactory.createAccountDao();

        //Insert
        userDao.insert(newUser);
        accountDao.insert(newAccount);

        //Update
        newAccount.setBalance(new BigDecimal("100000.00"));
        newAccount.setTransferLimit(newAccount.getBalance());
        newAccount.setTransferLimitCap(newAccount.getBalance());
        accountDao.update(newAccount);

        //Find by id
        IO.println(accountDao.findById(newAccount.getId()));

        //Find all
        accountDao.findAll().stream().forEach(account -> IO.println(account));

        //Delete
        accountDao.deleteById(newAccount.getId());
        userDao.deleteById(newUser.getId());

        DatabaseUtil.closeConnection();
    }

}