package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

import static javax.persistence.Persistence.createEntityManagerFactory;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/user?serverTimezone=UTC";
    private static final String username = "root";
    private static final String password = "root";


    public Util() {

    }

    public  static Connection databaseConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            System.out.println("Driver loaded success");

            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connection success");
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection failed...");
        }

        return null;
    }
    @Autowired
   // @PersistenceContext
  EntityManagerFactory emf = createEntityManagerFactory("jm.task.core.jdbc");
    public EntityManager em = emf.createEntityManager();



    // @PersistenceContext
   // public static EntityManager em ;
    // org.hibernate.Session session = (Session) em.getDelegate();
    // Session session =  em.unwrap(Session.class);

    //Session session = (Session) em.unwrap(Util.class);
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory()
            throws HibernateException {
        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.driver_class",
                        "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.url",
                        url)
                .setProperty("hibernate.connection.username",
                        username)
                .setProperty("hibernate.connection.password",
                        password)
                .setProperty("hibernate.connection.pool_size", "1")
                .setProperty("hibernate.connection.autocommit", "false")
                .setProperty("hibernate.cache.provider_class",
                        "org.hibernate.cache.NoCacheProvider")
                .setProperty("hibernate.cache.use_second_level_cache",
                        "false")
                .setProperty("hibernate.cache.use_query_cache", "false")
                .setProperty("hibernate.dialect",
                        "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.current_session_context_class",
                        "thread")
                .addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return  configuration.buildSessionFactory(builder.build());
        // return configuration.buildSettings()

    }

}
