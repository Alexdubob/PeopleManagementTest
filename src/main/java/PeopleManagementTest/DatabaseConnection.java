package PeopleManagementTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Scanner;

public class DatabaseConnection {
    Scanner scanner = new Scanner(System.in);
    private static final String URL = "jdbc:mysql://localhost:3306/PersonenVerwaltung";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    Connection connection = null;

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }


}