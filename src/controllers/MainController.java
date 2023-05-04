package controllers;

import java.util.ArrayList;
import views.CartView;
import views.MainView;
import views.Tabs;
import views.userViews.LoginView;
import views.userViews.RegistryView;
import models.restApi.RestApi;

public class MainController {

    MainView mainView;
    LoginView loginView;
    RegistryView registryView;
    CartView cartView;
    Tabs tab; 
    String token;
    RestApi restApi = new RestApi();

    public MainController() {
        this.mainView = new MainView();
        this.cartView = new CartView();
        this.loginView = new LoginView();
        this.registryView = new RegistryView();
        this.tab = new Tabs(this.mainView, this.cartView, this.loginView, this.registryView);
        this.isLoggedIn(this.token);
    }

    public Tabs getTab() {
        return this.tab;
    }

    public void setToken(String token) {
        this.token = token;
        this.isLoggedIn(token);
    }

    public void buyProduct(ArrayList<Integer> prodList){

        restApi.productsBought(prodList);
        String text = "Sikeres Vásárlás";
        tab.setLabelText(text);
    }
    
    public void isLoggedIn(String token){
        token = this.token;
        tab = getTab();
        if (token != "") {
            tab.addTabs();
            String text = "Bejelentkezve";
            tab.setLabelText(text);
        }
    }
}
