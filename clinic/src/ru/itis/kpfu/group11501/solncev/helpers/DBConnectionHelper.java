package ru.itis.kpfu.group11501.solncev.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Марат on 02.11.2016.
 */
public class DBConnectionHelper {
    private static final String URL =
            "jdbc:postgresql://localhost:5433/clinic";
    private static final String USER = "postgres";
    private static final String PSSWD = "postgres";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        URL, USER, PSSWD
                );
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
