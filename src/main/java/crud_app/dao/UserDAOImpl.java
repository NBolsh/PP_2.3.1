package crud_app.dao;

import crud_app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addUser(User user) {
        em.merge(user);
        em.flush();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        String jpql = "SELECT u From User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User findUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }


}
