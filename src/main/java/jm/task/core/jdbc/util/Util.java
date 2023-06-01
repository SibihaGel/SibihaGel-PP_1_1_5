package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.sql.*;
import java.util.Properties;

public class Util {

    private static SessionFactory sessionFactory = getSessionFactory();
    private static final String URL = "jdbc:mysql://@localhost:3306/user";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Casella2011";
    private static Connection connection = null;


    //    private static SessionFactory initSessionFactory(){
//        try {
//            return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
//        } catch (Throwable e) {
//            System.out.println("Не удалось создать соединение с БД " + e);
//            throw new ExceptionInInitializerError();
//        }
//    }
//        if (sessionFactory == null) {
//            initSessionFactory();
//        }
//        return sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mydatabase");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "Casella2011");

                configuration.setProperties(settings).addAnnotatedClass(User.class);
                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
               sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Сессия успешно создана");
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void close() {

        sessionFactory.close();
        System.out.println("Сессия закрыта");
    }
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД успешно установлено.");
            }
        } catch (SQLException e) {
            System.out.println("Не удалось загрузить драйвер");
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Соединение с БД успешно закрыто.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка закрытия соединения с БД.");
        }
    }

}


    

