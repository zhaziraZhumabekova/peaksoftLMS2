package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.UserDao;
import peaksoft.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("From User", User.class).getResultList();
        return users;
    }

    @Override
    public User getUserById(Long userId) {
        User user = entityManager.find(User.class, userId);
        return user;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(Long userId, User user) {
        User user1 = entityManager.find(User.class, userId);
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        entityManager.merge(user1);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }
}
