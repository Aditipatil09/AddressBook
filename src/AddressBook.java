import java.util.*;
import java.util.stream.Collectors;


class Person  {
    private String name;
    private String city;
    private String state;

    public Person(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
class AddressBook1 {
    private List<Person> contacts;

    public AddressBook1() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Person person) {
        contacts.add(person);
    }

    public List<Person> getContacts() {
        return contacts;
    }
    public void deleteContact(String name) {
        Iterator<Person> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

class AddressBook {


    public static List<Person> searchPersonInCityOrState(List<AddressBook1> addressBooks, String city, String state) {
        return addressBooks.stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(person -> person.getCity().equalsIgnoreCase(city) || person.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        AddressBook1 addressBook1 = new AddressBook1();
        addressBook1.addContact(new Person("Aditi", "Mumbai", "Maharashtra"));
        addressBook1.addContact(new Person("Ankita", "Navi Mumbai", "Mh"));

        AddressBook1 addressBook2 = new AddressBook1();
        addressBook2.addContact(new Person("Atharva", "Pune", "Maharshtra"));
        addressBook2.addContact(new Person("Pooja", "Nagpur", "Delhi"));


        List<AddressBook1> addressBooks = Arrays.asList(addressBook1, addressBook2);
        List<Person> searchResult = searchPersonInCityOrState(addressBooks, "Navi Mumbai", "Maharashtra");


        System.out.println("Search Result:");
        searchResult.forEach(person -> System.out.println(person.getName()));
    }
}