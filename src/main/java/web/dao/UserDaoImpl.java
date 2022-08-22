package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

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
        return  entityManager.createQuery("from User",User.class).getResultList();
    }

}