package dev.rynwllngtn.agorasystem.entities.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user")
public class User {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    protected UUID id;

    @Column(length = 11, nullable = false)
    protected String cpf;

    @Column(nullable = false)
    protected String password;

    protected String name;
    protected String email;

    @Column(name = "birth_date", nullable = false)
    protected Date birthDate;

    @Column(name = "is_active", nullable = false)
    protected boolean isActive = true;

    public User(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
        birthDate = new Date();
    }

    @Override
    public String toString() {

        if (isActive) {
            return ("ID: " + id + "\n" +
                    "CPF: " + cpf + "\n" +
                    "Password: " + password + "\n" +
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Birthdate: " + birthDate);
        }

        return "Esse usuário está com a conta desativada!";
    }

}