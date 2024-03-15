public class AddressBook {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public AddressBook(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void displayContact() {
        System.out.println("Contact details:");
        System.out.println("Name:" + firstName + "" + lastName);
        System.out.println("Address:" + address);
        System.out.println("City:" + city);
        System.out.println("State :" + state);
        System.out.println("Zip :" + zip);
        System.out.println("phoneNumber:" + phoneNumber);
        System.out.println("Email: " + email);
    }

    public static void main(String args[]) {
        AddressBook sampleContact = new AddressBook("John", "Singh", "Govandi", "Mumbai", "Maharshtra", "123", "8369326000", "aditi@gmail.com");
        sampleContact.displayContact();
    }
}


