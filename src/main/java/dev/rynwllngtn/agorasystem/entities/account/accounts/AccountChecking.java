package dev.rynwllngtn.agorasystem.entities.account.accounts;

import dev.rynwllngtn.agorasystem.entities.account.Account;
import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.enums.account.AccountType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.io.Serial;

@NoArgsConstructor
@Entity
@DiscriminatorValue("CHECKING")
public class AccountChecking extends Account {

    @Serial
    private static final long serialVersionUID = 7176933260932034186L;

    public AccountChecking(User holder) {
        super(holder);
        this.accountType = AccountType.CHECKING;
    }

}