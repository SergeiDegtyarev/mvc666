package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.service.ServiceDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceImpl implements ServiceDao {

    private final UserDao userDao;

    @Autowired
    public ServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateStudent(User user) {
        userDao.updateStudent(user);
    }

    @Override
    public void deleteStudent(User user) {
        userDao.deleteStudent(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}