package web.dao;

import web.model.User;

import java.util.List;


public interface UserDao {
    void addUser(User user);
    void updateStudent(User user);
    void deleteStudent(User user);

    List<User> getAllUsers();

}