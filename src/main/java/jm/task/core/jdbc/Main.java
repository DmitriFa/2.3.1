package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoImp;
import jm.task.core.jdbc.model.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class Main {

    public Main() {
    }
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/META-INF/db.properties");
            property.load(fis);

            String host = property.getProperty("db.url");
            String login = property.getProperty("db.username");
            String password = property.getProperty("db.password");

            System.out.println("HOST: " + host
                    + ", LOGIN: " + login
                    + ", PASSWORD: " + password);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }


        UserDaoImp userDao = new UserDaoImp();
        // userDao.dropUsersTable();
        //  userDao.createUsersTable();
        User user = new User("Вадим", "Анцупов", (byte) 38);
        userDao.addUser(user);
        //  userDao.saveUser("Василий", "Быков", (byte) 35);
        //userDao.saveUser("Дмитрий", "Фадеев", (byte) 17);
        //userDao.getAllUsers();
        //userDao.removeUserById(2);
        //userDao.cleanUsersTable();
    }

}