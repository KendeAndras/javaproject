package views.userViews;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import models.restApi.AuthService;

public class RegistryView extends VBox {
    UserInputView userInputView = new UserInputView();
    String text;
    Label nameLabel;
    Label emailLabel;
    Label passLabel;
    Label passConfirmLabel;
    TextField nameField;
    TextField emailField;
    TextField passField;
    TextField passConfirmField;

    public RegistryView() {
        this.AddToTab();
        this.setTextToNameLabel(nameLabel);
        this.setTextToEmailLabel(emailLabel);
        this.setTextToPassLabel(passLabel);
        this.setTextPassConfirmLabel(passConfirmLabel);
    }

    private void AddToTab() {

        this.nameLabel = userInputView.label;
        this.nameField = userInputView.field;

        this.emailLabel = userInputView.label;
        this.emailField = userInputView.field;

        this.passLabel = userInputView.label;
        this.passField = userInputView.field;

        this.passConfirmLabel = userInputView.label;
        this.passConfirmField = userInputView.field;

        this.getChildren().add(nameLabel);
        this.getChildren().add(nameField);
        this.getChildren().add(emailLabel);
        this.getChildren().add(emailField);
        this.getChildren().add(passLabel);
        this.getChildren().add(passField);
        this.getChildren().add(passConfirmLabel);
        this.getChildren().add(passConfirmField);
    }

    private void setTextToNameLabel(Label nameLabel) {
        this.text = "Név:";
        nameLabel.setText(text);
    }

    private void setTextToEmailLabel(Label emailLabel) {
        this.text = "Email:";
        emailLabel.setText(text);
    }

    private void setTextToPassLabel(Label passLabel) {
        this.text = "Jelszó:";
        passLabel.setText(text);
    }

    private void setTextPassConfirmLabel(Label passConfirmLabel) {
        this.text = "Jelszó újra";
        passConfirmLabel.setText(text);
    }

    private String getName(){
        String name = this.nameField.getText();
        return name;
    }

    private String getEmail(){
        String email = this.emailField.getText();
        return email;
    }

    private String getPass(){
        String pass = this.passField.getText();
        return pass;
    }

    private String getPassC(){
        String passConfirm = this.passConfirmField.getText();
        return passConfirm;
    }
    
    public void newUser(){
        AuthService authService = new AuthService();

        String name = this.getName();
        String email = this.getEmail();
        String pass = this.getPass();
        String passConfirm = this.getPassC();

        authService.registry(name, email, pass, passConfirm);
    }
}
