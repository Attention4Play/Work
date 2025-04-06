package entity;

public class Person {
    private String userName;
    private String login;
    private int salary;

    public void setUserName(String userName) {
        this.userName = userName; }
    public String getUserName() {
        return userName; }

    public void setLogin(String login) {
        this.login = login; }
    public String getLogin() {
        return login; }
    public void setSalary(int salary){
        this.salary = salary; }
    public int getSalary() {
        return salary; }
    @Override
    public String toString () {
        return "Имя пользователя: " + userName + ". Логин: " + login + ". Зарплата: " + salary;
    }
}
