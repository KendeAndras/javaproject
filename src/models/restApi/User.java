package models.restApi;

public class User {
    int id;
    String name;
    String email;
    String password;
    String confirm_password;

    public User(int id, String name, String email, String password, String confirm_password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
    }
}
