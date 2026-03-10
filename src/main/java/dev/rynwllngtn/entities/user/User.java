package dev.rynwllngtn.entities.user;

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
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1460773308039941743L;

    @EqualsAndHashCode.Include
    UUID id = UUID.randomUUID();
    String cpf;
    String password;
    String name;
    String email;
    Date birthDate;
    boolean isActive;

    public User(String cpf, String password) {
        this.cpf = cpf;
        this.password = password;
        isActive = true;
    }

    @Override
    public String toString() {

        if (isActive) {
            return ("CPF: " + cpf + "\n" +
                    "Password: " + password + "\n" +
                    "Name: " + name + "\n" +
                    "Email: " + email + "\n" +
                    "Birthdate: " + birthDate);
        }

        return "Esse usuário está com a conta desativada!";
    }

}