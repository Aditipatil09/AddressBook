import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AddressBookSystem {
    private Map<String, AddressBook1> addressBooks;

    public AddressBookSystem() {
        addressBooks = new HashMap<>();
    }

    public void addAddressBook(String name) {
        addressBooks.put(name, new AddressBook1());
    }

    public void addContact(String addressBookName, Contact contact) {
        AddressBook1 addressBook1 = addressBooks.get(addressBookName);
        if (addressBook1 != null) {
            addressBook1.addContact(contact);
        } else {
            System.out.println("Address book with name '" + addressBookName + "' not found.");
        }
    }

    public void deleteContact(String addressBookName, String contactName) {
        AddressBook1 addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.deleteContact(contactName);
        } else {
            System.out.println("Address book with name '" + addressBookName + "' not found.");
        }
    }

    public void displayContacts(String addressBookName) {
        AddressBook1 addressBook = addressBooks.get(addressBookName);
        if (addressBook != null) {
            addressBook.displayContacts();
        } else {
            System.out.println("Address book with name '" + addressBookName + "' not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookSystem addressBookSystem = new AddressBookSystem();

        boolean addMoreAddressBooks = true;
        while (addMoreAddressBooks) {
            System.out.println("Enter the name of the new address book:");
            String addressBookName = scanner.nextLine();
            addressBookSystem.addAddressBook(addressBookName);

            System.out.println("Do you want to add another address book? (yes/no)");
            String choice = scanner.nextLine().toLowerCase();
            addMoreAddressBooks = choice.equals("yes");
        }

        boolean continueOperations = true;
        while (continueOperations) {
            System.out.println("Enter the name of the address book to perform operations:");
            String selectedAddressBook = scanner.nextLine();

            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. Display Contacts");
            System.out.println("4. Exit");

            int operation = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (operation) {
                case 1:
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter phone number:");
                    String phoneNumber = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber);
                    addressBookSystem.addContact(selectedAddressBook, contact);
                    break;
                case 2:
                    System.out.println("Enter the name of the contact you want to delete:");
                    String deleteName = scanner.nextLine();
                    addressBookSystem.deleteContact(selectedAddressBook, deleteName);
                    break;
                case 3:
                    addressBookSystem.displayContacts(selectedAddressBook);
                    break;
                case 4:
                    continueOperations = false;
                    break;
                default:
                    System.out.println("Invalid operation. Please choose again.");
            }
        }

        scanner.close();
    }
}
