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
@DiscriminatorValue("SAVING")
public class AccountSaving extends Account {

    @Serial
    private static final long serialVersionUID = -5175368657497471716L;

    public AccountSaving(User holder) {
        super(holder);
        this.accountType = AccountType.SAVING;
    }

}