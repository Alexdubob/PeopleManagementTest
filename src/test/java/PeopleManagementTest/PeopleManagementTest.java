package PeopleManagementTest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class PeopleManagementTest {
    PeopleManagement pm;

    private List<Person> personList;

    @BeforeEach
    public void setup() {
        pm = new PeopleManagement();

    }

    @Test
    public void testCreatedPersonValidName() throws InvalidPersonNameException {
        String firstName = "Alex";
        String lastName = "Reinh";
        pm.createPerson(firstName, lastName);
        Assert.assertTrue(true);
        Assert.assertEquals(1, pm.personList.size());
    }


    @org.junit.jupiter.api.Test
    void testFindRightPerson() throws InvalidPersonNameException {
        String firstName = "Alex";
        String lastName = "Reinh";

        pm.createPerson(firstName, lastName);
        boolean result = pm.findPerson(firstName);
        Assert.assertTrue(result);

    }

    @Test
    void testFindWrongPerson() throws InvalidPersonNameException {
        String firstName = "";
        String lastName = "";

        pm.createPerson(firstName, lastName);
        boolean result = pm.findPerson(firstName);

        Assert.assertTrue(result);
        Assertions.assertThrows(NullPointerException.class, () -> {
            pm.findPerson("Person nicht vorhanden.");
        });
    }

    @org.junit.jupiter.api.Test
    void testIfContainsNumber() {
        String firstName = "Alex1";
        String lastName = "Reinh";

        boolean containsNumber1 = pm.containsNumber(firstName);
        boolean containsNumber2 = pm.containsNumber(lastName);

        Assert.assertTrue(containsNumber1);
        Assert.assertFalse(containsNumber2);
    }


    private void createPerson(String firstName, String lastName) throws InvalidPersonNameException {
        if (containsNumber(firstName) || containsNumber(lastName)) {
            throw new InvalidPersonNameException("Ungültiger Name! ");
        }
        Person person = new Person(firstName, lastName);
        personList.add(person);
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