public class Person {
    String userName;
    String login;

    public void setUserName(String userName) {
        this.userName = userName; }
    public String getUserName() {
        return userName; }

    public void setLogin(String login) {
        this.login = login; }
    public String getLogin() {
        return login; }
    @Override
    public String toString () {
        return "Имя пользователя: " + userName + ". Логин: " + login;
    }
}
