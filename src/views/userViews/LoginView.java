package views.userViews;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.restApi.AuthService;

public class LoginView extends VBox {
    UserInputView userInputView = new UserInputView();
    String text;
    Label nameLabel;
    Label passLabel;
    TextField nameField;
    TextField passField;
    String token;

    public LoginView() {
        this.AddToTab();
        this.setTextToNameLabel(nameLabel);
        this.setTextToPassLabel(passLabel);
    }

    private void AddToTab() {

        this.nameLabel = userInputView.label;
        this.nameField = userInputView.field;

        this.passLabel = userInputView.label;
        this.passField = userInputView.field;

        this.getChildren().add(nameField);
        this.getChildren().add(nameLabel);
        this.getChildren().add(passLabel);
        this.getChildren().add(passField);

    }

    private void setTextToNameLabel(Label nameLabel) {
        this.text = "Név:";
        nameLabel.setText(text);
    }

    private void setTextToPassLabel(Label passLabel) {
        this.text = "Jelszó:";
        passLabel.setText(text);
    }

    private String getName() {
        String name = this.nameField.getText();
        return name;
    }

    private String getPass() {
        String pass = this.passField.getText();
        return pass;
    }

    public void userLog() {
        AuthService authService = new AuthService();

        String name = this.getName();
        String pass = this.getPass();

        String token = authService.login(name, pass);
        
    }
}
