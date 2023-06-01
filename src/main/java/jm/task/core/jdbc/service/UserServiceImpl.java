package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public UserServiceImpl() throws SQLException {
    }

    public void createUsersTable() throws SQLException {
           userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() {
           userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
          userDaoHibernate.saveUser(name,lastName,age);
        System.out.println("user с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) {
          userDaoHibernate.removeUserById(id);
        System.out.println("User с Id " + id + " удален из базы данных");

    }

    public List<User> getAllUsers() {
        List<User> users = userDaoHibernate.getAllUsers();
              for (User user :users) {
            System.out.println(user);
        }
        return users;
    }


    public void cleanUsersTable() {
        userDaoHibernate.cleanUsersTable();
        System.out.println("Таблица очищена ");
    }
}
