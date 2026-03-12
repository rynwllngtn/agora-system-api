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
    protected UUID id = UUID.randomUUID();
    protected String cpf;
    protected String password;
    protected String name;
    protected String email;
    protected Date birthDate;
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