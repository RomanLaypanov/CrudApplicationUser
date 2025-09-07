package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
@Transactional()
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User updateUser) {
        entityManager.merge(updateUser);
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}