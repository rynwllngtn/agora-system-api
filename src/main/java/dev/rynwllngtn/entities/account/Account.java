package dev.rynwllngtn.entities.account;

import dev.rynwllngtn.entities.user.User;
import dev.rynwllngtn.enums.account.AccountType;
import jakarta.persistence.*;
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
@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "accountType", discriminatorType = DiscriminatorType.STRING)
public abstract class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = -5407895841045304833L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    protected UUID id;

    @ManyToOne
    @JoinColumn( nullable = false)
    protected User holder;

    @Column(precision = 9, scale = 2)
    protected BigDecimal balance;

    @Column(precision = 9, scale = 2)
    protected BigDecimal transferLimit;

    @Column(precision = 9, scale = 2)
    protected BigDecimal transferLimitCap;

    @Enumerated(EnumType.STRING)
    @Column(length = 16, insertable=false, updatable=false)
    protected AccountType accountType;

    public Account(User holder) {
        this.holder = holder;
        balance = BigDecimal.ZERO;
        transferLimit = balance;
        transferLimitCap = transferLimit;
    }

    @Override
    public String toString() {
        return ("Account ID: " + id + "\n" +
                "Holder:\n\n" + holder + "\n\n" +
                "Transaction Limit: " + transferLimit +  " | " + transferLimitCap + "\n" +
                "Balance: " + balance);
    }

}