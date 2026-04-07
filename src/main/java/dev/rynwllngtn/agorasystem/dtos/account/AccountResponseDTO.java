package dev.rynwllngtn.agorasystem.dtos.account;

import dev.rynwllngtn.agorasystem.entities.account.Account;
import dev.rynwllngtn.agorasystem.enums.account.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public record AccountResponseDTO(
        BigDecimal balance,
        BigDecimal transferLimit,
        BigDecimal transferLimitCap,
        AccountType accountType
) {
    public AccountResponseDTO(Account account) {
        this(account.getBalance(),
             account.getTransferLimit(),
             account.getTransferLimitCap(),
             account.getAccountType());
    }

}