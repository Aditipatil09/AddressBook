import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Contact {
    String Name ;
    String phoneNumber;

    public Contact(String Name , String phoneNumber){
        this.Name = Name;
        this.phoneNumber=phoneNumber;
    }
    public String getName(){
        return Name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String toString(){
        return "Name" +Name+ ",phoneNumber" +phoneNumber ;
    }
}
class AddressBook{
    private List<Contact> contacts;

    public AddressBook(){
        contacts = new ArrayList<>();
    }
    public void addContact (Contact contact){
        contacts.add(contact);
    }
    public void displayContact(){
        if (contacts. isEmpty()){
            System.out.println("Address Book is Empty:");
        } else {
            System.out.println("Address in contact book:");

            for(Contact contacts : contacts){
                System.out.println(contacts);
            }
        }
    }
}
class AddressBookMain{
    public static void main(String args[]){
        Scanner scanner = new Scanner (System.in);
        AddressBook addressBook = new AddressBook();

        System .out.println("Enter the Name:");
        String Name = scanner.nextLine();

        System.out.println("Enter the Phone Number:");
        String phoneNumber = scanner.nextLine();

        Contact newContact = new Contact(Name  , phoneNumber);
        addressBook.addContact (newContact);

        addressBook.displayContact();

        scanner.close();

    }
}


