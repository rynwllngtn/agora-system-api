package dev.rynwllngtn.agorasystem;

import dev.rynwllngtn.agorasystem.entities.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User("12312312312", "123123123");
        return ResponseEntity.ok().body(user);
    }
}
