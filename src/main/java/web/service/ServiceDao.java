package web.service;

import web.model.User;

import java.util.List;

public interface ServiceDao {
    void addUser(User user);
    User findById(int id);
    void updateUser(User user);

    void deleteUser(int id);

    List<User> getAllUsers();
}