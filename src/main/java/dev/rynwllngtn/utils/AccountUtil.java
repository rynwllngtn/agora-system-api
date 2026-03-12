package dev.rynwllngtn.utils;

import dev.rynwllngtn.entities.account.Account;
import dev.rynwllngtn.entities.account.accounts.AccountChecking;
import dev.rynwllngtn.entities.account.accounts.AccountSaving;
import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.enums.account.AccountType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AccountUtil {

    public static Account instantiateAccount(ResultSet resultSet, User user) throws SQLException {

        AccountType accountType = AccountType.valueOf(resultSet.getString("AccountType"));

        switch (accountType) {
            case AccountType.CHECKING -> {
                Account account = new AccountChecking();
                account.setId(UUID.fromString(resultSet.getString("Id")));
                account.setHolder(user);
                account.setBalance(resultSet.getBigDecimal("Balance"));
                account.setTransferLimit(resultSet.getBigDecimal("TransferLimit"));
                account.setTransferLimitCap(resultSet.getBigDecimal("TransferLimitCap"));
                account.setAccountType(accountType);
                return account;
            }
            case AccountType.SAVING -> {
                Account account = new AccountSaving();
                account.setId(UUID.fromString(resultSet.getString("Id")));
                account.setHolder(user);
                account.setBalance(resultSet.getBigDecimal("Balance"));
                account.setTransferLimit(resultSet.getBigDecimal("TransferLimit"));
                account.setTransferLimitCap(resultSet.getBigDecimal("TransferLimitCap"));
                account.setAccountType(accountType);
                return account;
            }
            default -> {
                return null;
            }
        }
    }

}