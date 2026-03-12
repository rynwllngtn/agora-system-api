package dev.rynwllngtn.entities.account.accounts;

import dev.rynwllngtn.entities.account.Account;
import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.enums.account.AccountType;
import lombok.NoArgsConstructor;

import java.io.Serial;

@NoArgsConstructor
public class AccountChecking extends Account {

    @Serial
    private static final long serialVersionUID = 7176933260932034186L;

    public AccountChecking(User holder) {
        super(holder);
        this.accountType = AccountType.CHECKING;
    }

}