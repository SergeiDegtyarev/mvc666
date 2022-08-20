package web.dao;

import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void addUser(User user) {
        entityManager.persist(user);
    }


    public void updateStudent(User user) {
        entityManager.merge(user);
    }


    public void deleteStudent(User user) {
        entityManager.remove(user);
    }


    public List<User> getAllUsers() {
        return  entityManager.createNativeQuery("from user",User.class).getResultList();
    }

}