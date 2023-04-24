package views.userViews;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginView extends VBox {
    UserInputView userInputView = new UserInputView();
    String text;
    Label nameLabel;
    Label passLabel;
    TextField nameField;
    TextField passField;
    
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

    }

    private void setTextToNameLabel(Label nameLabel) {
        this.text = "Név:";
        nameLabel.setText(text);
    }

    private void setTextToPassLabel(Label passLabel) {
        this.text = "Jelszó:";
        passLabel.setText(text);
    }
}
