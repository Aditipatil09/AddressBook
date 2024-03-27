import java.util.HashSet;
import java.util.Set;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class AddressBook1 {
    private Set<Person> persons = new HashSet<>();

    public void addPerson(Person person) {
        if (persons.stream().anyMatch(p -> p.equals(person))) {
            System.out.println("Duplicate entry: " + person.getName());
        } else {
            persons.add(person);
            System.out.println("Added: " + person.getName());
        }
    }

    public void displayAddressBook1() {
        System.out.println("Address Book:");
        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }
}

 class Main {
    public static void main(String[] args) {
        AddressBook1 addressBook1 = new AddressBook1();

        // Adding persons to the address book
        addressBook1.addPerson(new Person("Aditi"));
        addressBook1.addPerson(new Person("Ankita"));
        addressBook1.addPerson(new Person("Aditi")); // Duplicate entry
        addressBook1.addPerson(new Person("pooja"));

        // Display the address book
        addressBook1.displayAddressBook1();
    }
}