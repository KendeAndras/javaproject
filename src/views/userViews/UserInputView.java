package views.userViews;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class UserInputView extends VBox {
    Label label;
    TextField field;

    public UserInputView() {
        this.initComponent();
        this.addComponent();
    }

    private void initComponent() {
        this.label = new Label();
        this.field = new TextField();
    }

    public void addComponent() {
        this.getChildren().add(this.label);
        this.getChildren().add(this.field);
    }

    public String getText() {
        return label.getText();
    }

    public void setText(String text) {
        this.label.setText(text);
    }
    public String getValue() {
        return field.getText();
    }
    public void setValue(String value) {
        this.field.setText(value);
    }
}