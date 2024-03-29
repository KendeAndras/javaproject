import controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.Tabs;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        MainController mainController = new MainController();
        Tabs tab = mainController.getTab();

        Scene scene = new Scene(tab, 1000, 1000);
        stage.setScene(scene);
        stage.setTitle("Football Marketplace");
        stage.show();
    }

}
