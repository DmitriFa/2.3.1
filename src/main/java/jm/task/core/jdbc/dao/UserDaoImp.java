package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;


public class UserDaoImp implements UserDao {
    public UserDaoImp() {
    }


    @Override
    public void createUsersTable() throws SQLException {

    }

    @Override
    public TransactionDefinition dropUsersTable() throws SQLException {
        return null;
    }

    @Autowired
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jm.task.core.jdbc");
    @PersistenceContext
    EntityManager em = emf.createEntityManager();

    @Override
    public void addUser(User user) throws HibernateException, SQLException {
        System.out.println(user.toString());
     //    EntityManagerFactory emf = hc.getEntityManagerFactoryBean().getObject();

        em.getTransaction().begin();
        em.persist(user);
        em.flush();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws HibernateException {

    }

    @Override
    public void removeUserById(long id) throws HibernateException {
    }

    @Override
    public void updateUserById(long id) throws SQLException {

    }

    @Override
    public List<User> getAllUsers() throws SQLException {

        return null;
    }

    @Override
    public void cleanUsersTable() throws SQLException {

    }
}
