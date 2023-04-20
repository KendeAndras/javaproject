package controllers;

import views.MainView;
import views.Tabs;

public class MainController {

    MainView mainView;
    Tabs tab;

    public MainController() {
        this.mainView = new MainView();
        this.tab = new Tabs(this.mainView);
        
    }
    public Tabs getTab() {
        return this.tab;
    }  
    
}
