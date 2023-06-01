package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
         public static void main(String[] args) throws SQLException {


     final UserService userService = new UserServiceImpl();

      userService.createUsersTable();



        userService.saveUser("Nicola","Sar-cozy",(byte) 54);
         userService.saveUser("Voloda", "Put-In", (byte) 20);
         userService.saveUser("Any_name", "AnnyLastName", (byte) 25);
        userService.saveUser("Any_name1", "AnnyLastName1", (byte) 31);


         userService.removeUserById(1);
         userService.getAllUsers();
         userService.cleanUsersTable();
         userService.dropUsersTable();
         Util.close();
    }
}
