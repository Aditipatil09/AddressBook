import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
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

    @Override
    public String toString() {
        return "Person{name='" + name + "', city='" + city + "', state='" + state + "'}";
    }
}

class AddressBook {
    private List<Person> persons;

    public AddressBook() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
class Main {
    public static List<Person> searchPersonInCityOrState(List<AddressBook> addressBooks, String cityOrState) {
        return addressBooks.stream()
                .flatMap(addressBook -> addressBook.getPersons().stream())
                .filter(person -> person.getCity().equalsIgnoreCase(cityOrState) || person.getState().equalsIgnoreCase(cityOrState))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        AddressBook addressBook1 = new AddressBook();

        addressBook1.addPerson(new Person("Aditi", "Mumbai", "MH"));
        addressBook1.addPerson(new Person("Ankita", "Nagpur", "Delhi"));

        AddressBook addressBook2 = new AddressBook();
        addressBook2.addPerson(new Person("Aditi", "Pune", "MH"));
        addressBook2.addPerson(new Person("Pooja", "Mumbai", "NY"));



        List<AddressBook> addressBooks = List.of(addressBook1, addressBook2);

        List<Person> searchResult = searchPersonInCityOrState(addressBooks, "NY");
        System.out.println("Search Result:");
        searchResult.forEach(System.out::println);
    }
}