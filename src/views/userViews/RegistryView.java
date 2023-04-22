package views.userViews;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
    TextField assConfirmField;

    public RegistryView() {
        this.AddToTab();
        this.setTextToNameLabel(nameLabel);
    }

    private void AddToTab() {

        this.nameLabel = userInputView.label;
        this.nameField = userInputView.field;

        this.emailLabel = userInputView.label;
        this.emailField = userInputView.field;

        this.passLabel = userInputView.label;
        this.passField = userInputView.field;

        this.passConfirmLabel = userInputView.label;
        this.assConfirmField = userInputView.field;
    }

    private void setTextToNameLabel(Label nameLabel){
        this.text = "Név";
        nameLabel.setText(text);
    }
}
