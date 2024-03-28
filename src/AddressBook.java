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
        persons.add(new Person("Alice", "Navi Mumbai", "MH"));
        persons.add(new Person("Aditi", "Mumbai", "Gj"));
        persons.add(new Person("Bob", "Nagpur", "Delhi"));
        persons.add(new Person("Pooja", "Pune", "NY"));

        // Count persons by city
        Map<String, Long> cityPersonCount = persons.stream()
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()));

        System.out.println("Count of Persons by City:");
        for (Map.Entry<String, Long> entry : cityPersonCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Count persons by state
        Map<String, Long> statePersonCount = persons.stream()
                .collect(Collectors.groupingBy(Person::getState, Collectors.counting()));

        System.out.println("\nCount of Persons by State:");
        for (Map.Entry<String, Long> entry : statePersonCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}