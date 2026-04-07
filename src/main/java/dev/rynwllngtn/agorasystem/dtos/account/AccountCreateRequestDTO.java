package dev.rynwllngtn.agorasystem.dtos.account;

import dev.rynwllngtn.agorasystem.entities.account.Account;
import dev.rynwllngtn.agorasystem.entities.account.accounts.AccountChecking;
import dev.rynwllngtn.agorasystem.entities.account.accounts.AccountSaving;
import dev.rynwllngtn.agorasystem.enums.account.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountCreateRequestDTO(
        UUID holder,
        BigDecimal balance,
        BigDecimal transferLimit,
        BigDecimal transferLimitCap,
        AccountType accountType
) {
    public Account getAccount() {
        return switch (accountType) {
            case CHECKING -> new AccountChecking(balance, transferLimit, transferLimitCap);
            case SAVING -> new AccountSaving(balance,transferLimit, transferLimitCap);
            case NONE -> null;
        };
    }

}