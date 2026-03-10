package dev.rynwllngtn.entities.account;

import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.enums.account.AccountType;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = -5407895841045304833L;

    @EqualsAndHashCode.Include
    protected UUID id = UUID.randomUUID();
    protected User holder;
    protected BigDecimal balance;
    protected BigDecimal transferLimit;
    protected BigDecimal transferLimitCap;
    protected AccountType accountType;

    public Account(User holder) {
        this.holder = holder;
        balance = BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return ("ID: " + id + "\n" +
                "Owner: " + holder.getName() + "\n" +
                "Transaction Limit: " + transferLimit +  " / " + transferLimitCap + "\n" +
                "Balance: " + balance);
    }

}