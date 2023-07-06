package PeopleManagementTest;
import java.sql.*;
import java.util.ArrayList;

public class PeopleManagement {
    ArrayList<Person> personList = new ArrayList<>();
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personenverwaltung",
      "root", "");

    public PeopleManagement() throws SQLException {
    }

    public void createPerson(String firstName, String lastName) throws InvalidPersonNameException, SQLException {
        if (containsNumber(firstName) || containsNumber(lastName)) {
            throw new InvalidPersonNameException("Ungültiger Name! ");
        }
        String query = "INSERT INTO persons (FirstName,LastName) VALUES" + "('" + firstName + "','" + lastName + "');";
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();



        Person person = new Person(firstName, lastName);
        personList.add(person);
    }

    public void createPerson(String firstName, String lastName, String birthday, Adress adress, Gender gender) throws SQLException {
        Person person = new Person(firstName, lastName, birthday, adress, gender);
        String query = "INSERT INTO persons (FirstName,LastName) VALUES" + "('" + firstName + "','" + lastName + "','" + birthday + "','" + adress + "','" + gender + ");";
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();
        personList.add(person);

    }

    public void createPerson(String firstName, String lastName, String birthday, Gender gender) throws SQLException {
        Person person = new Person(firstName, lastName, birthday, gender);
        String query = "INSERT INTO persons (FirstName,LastName) VALUES" + "('" + firstName + "','" + lastName + "','" + birthday + "','" +  gender + ");";
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();
        personList.add(person);
    }

    public void deletePerson(Person person) {
        personList.remove(person);
    }

    public boolean findPerson(String name) {
        boolean personFound = false;
        for (Person p : personList) {
            if (p.getFirstName().equals(name) || p.getLastName().equals(name)) {
                System.out.println("Person gefunden: " + p.toString());
                personFound = true;
                return true;
            }
        }
        if (!personFound) {
            throw new NullPointerException("Person nicht vorhanden.");
        }
        return false;
    }

    public String printDB(){
        try{
        String query = "SELECT * FROM persons ORDER BY PersonID ASC";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        int columns = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columns; i++)
            System.out.println(rs.getMetaData().getColumnLabel(i));
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i <= columns; i++)
                System.out.println(rs.getString(i));
            System.out.println();
        }
        rs.close();
        statement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return printDB();
    }

    public String toString() {
        String s = "";
        for (Person p : personList) {
            s += p.toString() + "\n";
        }
        return s;
    }

    public boolean containsNumber(String name) {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}








