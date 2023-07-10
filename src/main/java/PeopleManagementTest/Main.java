package PeopleManagementTest;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
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


        PeopleManagement pm = new PeopleManagement();
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        int option = 0;
        System.out.println("What would you like to do?");
        System.out.println("1. create person");
        System.out.println("2. looking for a person");
        System.out.println("3. delete a person");

        String input = scanner.nextLine();
        option = Integer.parseInt(input);

        if (option == 1)
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


                System.out.println("Möchtest du eine weitere Person erstellen? j/n oder :q! zum beenden");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("n")) {
                    done = true;
                } else if (choice.equals(":q!")) {
                    System.out.println("Programm wird beendet...");
                    System.exit(0);
                }
            }


        else if (option == 2) {
            while (true) {
                System.out.println("Welche person möchtest du suchen? :q! zum beenden!");
                String lfPerson = scanner.nextLine();
                String query = "SELECT * FROM persons WHERE firstNAme  = '" + lfPerson + "';";
                pm.printDB(query);

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

        else if (option == 3) {
            System.out.println("Welche Person möchtst du löschen");
            String chosePersonDelete = scanner.nextLine();
            pm.deletePerson(chosePersonDelete);
        }
        System.out.println(pm.toString());
        String query = "SELECT * FROM persons ORDER BY PersonID ASC";
        pm.printDB(query);
    }
}
