package dev.rynwllngtn.agorasystem.entities.account;

import dev.rynwllngtn.agorasystem.test.AccountRequest;
import dev.rynwllngtn.agorasystem.entities.user.User;
import dev.rynwllngtn.agorasystem.enums.account.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Account {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    protected UUID id;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected User holder;

    @Column(precision = 9, scale = 2)
    protected BigDecimal balance;

    @Column(name = "transfer_limit", precision = 9, scale = 2)
    protected BigDecimal transferLimit;

    @Column(name = "transfer_limit_cap", precision = 9, scale = 2)
    protected BigDecimal transferLimitCap;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", length = 16, insertable = false, updatable = false)
    protected AccountType accountType;

    public Account(User holder) {
        this.holder = holder;
        balance = BigDecimal.ZERO;
        transferLimit = balance;
        transferLimitCap = transferLimit;
    }

    public Account(AccountRequest accountRequest) {
        holder = accountRequest.getHolder();
        balance = accountRequest.getBalance();
        transferLimit = accountRequest.getTransferLimit();
        transferLimitCap = accountRequest.getTransferLimitCap();
    }

    @Override
    public String toString() {
        return ("Account ID: " + id + "\n" +
                "Holder:\n\n" + holder + "\n\n" +
                "Transaction Limit: " + transferLimit +  " | " + transferLimitCap + "\n" +
                "Balance: " + balance);
    }

}