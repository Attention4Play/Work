package service;
import com.github.javafaker.Faker;
import com.squareup.okhttp.*;
import entity.Person;
import lombok.SneakyThrows;
import java.util.List;
import java.util.ArrayList;

public class PersonService {
    Faker faker = new Faker();
    public List<Person> generateFakePersons() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Person person = new Person();
            person.setUserName(faker.name().fullName());
            person.setLogin(faker.pokemon().name());
            person.setSalary((int)faker.number().randomNumber());
            persons.add(person);
        }
        int counter = 1;
        for (Person person : persons) {
            System.out.println(counter + ". " + person);
            counter++;
        }
        return persons;
    }
    public List<Person> getFilteredFakePersonsOnSalary (List<Person> persons, long minSalary) {
        List<Person> filteredFakePersons = new ArrayList<>();
        for (Person person : persons) {
            if (person.getSalary() > minSalary) {
                filteredFakePersons.add(person);
                System.out.println(person);
            }
        }
        return filteredFakePersons;
    }

    @SneakyThrows
    public String recieveFakePersonsFromSite() {
        Request request = new Request.Builder()
                .url("https://randomuser.me/api/")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response);
        return response.toString();
    }
}