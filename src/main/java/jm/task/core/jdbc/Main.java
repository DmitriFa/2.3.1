package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoImp;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;

public class Main {

    public Main() {
    }
    public static void main(String[] args) throws SQLException {
        UserDaoImp userDao = new UserDaoImp();
   // userDao.dropUsersTable();
  //  userDao.createUsersTable();
   User user = new User("Вадим","Анцупов",(byte)38);
   userDao.addUser(user);
  //  userDao.saveUser("Василий", "Быков", (byte) 35);
   //userDao.saveUser("Дмитрий", "Фадеев", (byte) 17);
    //userDao.getAllUsers();
    //userDao.removeUserById(2);
    //userDao.cleanUsersTable();

    }
}