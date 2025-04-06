package service;
import com.github.javafaker.Faker;
import entity.Person;
import java.util.List;
import java.util.ArrayList;

public class PersonService {
    Faker faker = new Faker();
    public void generateFakePersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Person person = new Person();
            person.setUserName(faker.name().fullName());
            person.setLogin(faker.pokemon().name());
            persons.add(person);
        }
        int counter = 1;
        for (Person person : persons) {
            System.out.println(counter + ". " + person);
            counter++;
        }
    }
}
