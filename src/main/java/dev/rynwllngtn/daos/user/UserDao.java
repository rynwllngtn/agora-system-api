package dev.rynwllngtn.daos.user;

import dev.rynwllngtn.entities.user.User;

import java.util.List;

public interface UserDao {

    void insert(User user);
    void delete(User user);
    void deleteById(int id);
    User findById(int id);
    List<User> findAll();

}