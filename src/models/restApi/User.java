package models.restApi;

public class User {
    String name;
    String email;
    String password;
    String confirm_password;

    public User(String name, String email, String password, String confirm_password) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
