package PeopleManagementTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/PersonenVerwaltung";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    Connection connection = null;

    public static Connection buildConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);

    }


}