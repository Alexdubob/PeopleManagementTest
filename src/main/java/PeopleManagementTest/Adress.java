package PeopleManagementTest;

class Adress {
    String postalCode;
    String location;
    String streetName;
    String streetNumber;

    public Adress(String postalCode, String location, String streetName, String streetNumber) {
        this.postalCode = postalCode;
        this.location = location;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }

    @Override
    public String toString() {
        return "{Postal Code: " + postalCode +
                ", Location: " + location +
                ", Street Name: " + streetName +
                ", Street Number: " + streetNumber +
                "}";
    }
}