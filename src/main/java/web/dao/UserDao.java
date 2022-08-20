package web.dao;

import web.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    void addUser(User user);
    void updateStudent(User user);
    void deleteStudent(User user);

    List<User> getAllUsers();

}