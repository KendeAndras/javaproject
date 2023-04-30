package views.userViews;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
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
    Button registryButton;

    public RegistryView() {
        this.AddToTab();
        this.setTextToNameLabel();
        this.setTextToEmailLabel();
        this.setTextToPassLabel();
        this.setTextPassConfirmLabel();
        this.setTextToButton();
        this.setButtonAction();
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

        this.registryButton = userInputView.button;;

        this.getChildren().add(nameLabel);
        this.getChildren().add(nameField);
        this.getChildren().add(emailLabel);
        this.getChildren().add(emailField);
        this.getChildren().add(passLabel);
        this.getChildren().add(passField);
        this.getChildren().add(passConfirmLabel);
        this.getChildren().add(passConfirmField);
        this.getChildren().add(registryButton);
    }

    private void setTextToNameLabel() {
        this.text = "Név:";
        nameLabel.setText(text);
    }

    private void setTextToEmailLabel() {
        this.text = "Email:";
        emailLabel.setText(text);
    }

    private void setTextToPassLabel() {
        this.text = "Jelszó:";
        passLabel.setText(text);
    }

    private void setTextPassConfirmLabel() {
        this.text = "Jelszó újra";
        passConfirmLabel.setText(text);
    }

    private void setTextToButton() {
        this.text = "Regisztráció";
        registryButton.setText(text);
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

    private void setButtonAction() {
        registryButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent aEvent) {
                newUser();
            }
        });
    }
}
