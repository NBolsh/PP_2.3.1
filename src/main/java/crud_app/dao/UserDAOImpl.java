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
        em.persist(user);
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
    public void deleteUser(User user) {
        em.remove(user);
    }

    @Override
    public void editUser(User user) {

    }
}
