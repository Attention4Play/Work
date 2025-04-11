import entity.Person;
import service.PersonService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Person person = new Person();
//        System.out.print("Введите ваш ник: ");
//        person.setUserName(scan.nextLine());
//        System.out.print("Введите ваш логин: ");
//        person.setLogin(scan.nextLine());
//        System.out.println(person);
        PersonService personService = new PersonService();
        personService.generateFakePersons();
        personService.getFilteredFakePersonsOnSalary(personService.generateFakePersons(), 1000000);
        System.out.println(personService.recieveFakePersonsFromSite());
    }
}