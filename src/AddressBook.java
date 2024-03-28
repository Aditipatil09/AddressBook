
import java.util.*;
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

class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aditi", "Mumbai", "MH"));
        persons.add(new Person("Ankita", "Pune", "Gj"));
        persons.add(new Person("Pooja", "Nagpur", "IL"));
        persons.add(new Person("David", "Delhi", "NY"));

        // Group persons by city
        Map<String, List<Person>> cityPersonMap = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity));

        System.out.println("Persons by City:");
        for (Map.Entry<String, List<Person>> entry : cityPersonMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        Map<String, List<Person>> statePersonMap = persons.stream()
                .collect(Collectors.groupingBy(Person::getState));

        System.out.println("\nPersons by State:");
        for (Map.Entry<String, List<Person>> entry : statePersonMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}