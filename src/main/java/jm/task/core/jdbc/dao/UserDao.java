package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.springframework.transaction.TransactionDefinition;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    void createUsersTable() throws SQLException;

    TransactionDefinition dropUsersTable() throws SQLException;

    void addUser(User user) throws SQLException, Exception;

    void saveUser(String name,String lastName,byte age);

    void removeUserById(long id) throws SQLException;

    void updateUserById(long id) throws SQLException;

    List<User> getAllUsers() throws SQLException;

    void cleanUsersTable() throws SQLException;
}
