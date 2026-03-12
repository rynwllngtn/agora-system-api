package dev.rynwllngtn.agorasystem.entities.user;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1460773308039941743L;

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

    @Column(nullable = false)
    protected Date birthDate;

    @Column(nullable = false)
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