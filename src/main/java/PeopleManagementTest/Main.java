package PeopleManagementTest;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
     /*   try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Personenverwaltung",
                    "root", "");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/

        PeopleManagement pm = new PeopleManagement();
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.println("firstName: ");
            String firstName = scanner.nextLine();

            System.out.println("lastName: ");
            String lastName = scanner.nextLine();

            try {
                pm.createPerson(firstName, lastName);
                System.out.println("Person erfolgreich erstellt.");
            } catch (InvalidPersonNameException e) {
                System.out.println("Fehler: " + e.getMessage());
            }


            System.out.println("Möchtest du eine weitere Person erstellen? j/n");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("n")) {
                done = true;
            } else if (choice.equals(":q!")) {
                System.out.println("Programm wird beendet...");
                System.exit(0);
            }
        }

        //System.out.println(pm.toString());

        while (true) {
            System.out.println("Welche person möchtest du suchen?");
            String lfPerson = scanner.nextLine();

            if (lfPerson.equals(":q!")) {
                System.out.println("Programm wird beendet...");
                System.exit(0);
            }
            try {
                pm.findPerson(lfPerson);
            } catch (NullPointerException e) {
                System.out.println("Fehler: " + e.getMessage());

            }
        }
    }
}
