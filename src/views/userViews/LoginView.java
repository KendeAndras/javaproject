package views.userViews;

import javafx.event.EventHandler;
import controllers.MainController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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
    Button logButton;

    public LoginView() {
        this.AddToTab();
        this.setTextToNameLabel();
        this.setTextToPassLabel();
        this.setTextToButton();
        this.setButtonAction();
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
        this.getChildren().add(logButton);

    }

    private void setTextToNameLabel() {
        this.text = "Név:";
        nameLabel.setText(text);
    }

    private void setTextToPassLabel() {
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

    private void setTextToButton() {
        this.text = "Regisztráció";
        logButton.setText(text);
    }

    public void loginUser() {
        AuthService authService = new AuthService();

        String name = this.getName();
        String pass = this.getPass();

        String token = authService.login(name, pass);
        
        MainController mainController = new MainController();
        mainController.setToken(token);
    }

    private void setButtonAction() {
        logButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent aEvent) {
                loginUser();
            }
        });
    }
}
