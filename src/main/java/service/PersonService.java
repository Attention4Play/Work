package service;
import com.github.javafaker.Faker;
import com.squareup.okhttp.*;
import entity.Person;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.json.JSONArray;
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
    public Person recieveFakePersonsFromSite() {
        Request request = new Request.Builder()
                .url("https://randomuser.me/api/")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);
        response.toString();

        JSONObject jsonObject = new JSONObject(responseBody);
        Person person = new Person();
        String userName = jsonObject
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("name")
                .getString("first")
                + " "
                + jsonObject.getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("name")
                .getString("last");
        person.setUserName(userName);     // но можно и в параметры сеттера всё прописать вместо userName
        String login = jsonObject
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("login")
                .getString("username");
        person.setLogin(login);
        String phoneNumber = String.valueOf(jsonObject
                .getJSONArray("results")
                .getJSONObject(0)
                .getString("phone"));
        person.setPhoneNumber(phoneNumber);
        String city = jsonObject
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("location")
                .getString("city");
        person.setCity(city);
        String country = jsonObject
                .getJSONArray("results")
                .getJSONObject(0)
                .getJSONObject("location")
                .getString("country");
        person.setCountry(country);
        return person;
    }
}