import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void deleteContact(String name) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("Contacts in Address Book:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

 class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();


        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();

        Contact newContact = new Contact(name, phoneNumber);
        addressBook.addContact(newContact);


        addressBook.displayContacts();


        System.out.println("Enter the name of the contact you want to delete:");
        String deleteName = scanner.nextLine();

        addressBook.deleteContact(deleteName);


        addressBook.displayContacts();

        scanner.close();
    }
}


