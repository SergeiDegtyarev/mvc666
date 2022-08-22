package web.service;

import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceImpl implements ServiceDao {

    private  UserDao userDao;

    @Autowired
    public ServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateStudent(User user) {
        userDao.updateStudent(user);
    }

    @Override
    @Transactional
    public void deleteStudent(User user) {
        userDao.deleteStudent(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}