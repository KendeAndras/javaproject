package controllers;

import models.Product;
import views.CartView;
import views.MainView;
import views.Tabs;
import views.userViews.LoginView;
import views.userViews.RegistryView;

public class MainController {

    MainView mainView;
    LoginView loginView;
    RegistryView registryView;
    CartView cartView;
    Tabs tab;
    Product product;
    Product soldProd;

    public MainController() {
        this.mainView = new MainView();
        this.loginView = new LoginView();
        this.registryView = new RegistryView();
        this.tab = new Tabs(this.mainView, this.cartView, this.loginView, this.registryView);
        
    }

    public Tabs getTab() {
        return this.tab;
    }

    public void buyProduct(){
    
        // TODO handle output product
    }
    
}
