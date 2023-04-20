package views;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Tabs extends TabPane {
    Tab productTab;
    Tab loginTab;
    Tab registryTab;
    MainView mainView;
    LoginView loginView;
    RegistryView registryView;

    public Tabs (MainView mainView) {
        this.mainView = mainView;
        this.loginView = loginView;
        this.registryView = registryView;
        this.initComponent();
        this.addComponent();
        
    }

    private void initComponent() {
        this.productTab = new Tab("Termékeink", this.mainView);
        this.loginTab = new Tab("Belépés", this.loginView);
        this.registryTab = new Tab("Regisztráció", this.registryView);
    }

    private void addComponent() {
        this.getTabs().add(this.productTab);
        this.getTabs().add(this.loginTab);
        this.getTabs().add(this.registryTab);
    }
    
}

