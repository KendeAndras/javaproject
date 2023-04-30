package controllers;

import models.Product;
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
    Product soldProd;
    RestApi restApi = new RestApi();

    public MainController() {
        this.isLoggedIn(this.token);
        this.mainView = new MainView();
        this.loginView = new LoginView();
        this.registryView = new RegistryView();
        this.tab = new Tabs(this.mainView, this.cartView, this.loginView, this.registryView);
        
    }

    public Tabs getTab() {
        return this.tab;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void buyProduct(){
        String text = "Sikeres Vásárlás";
        restApi.productsBought(cartView.buy());
        tab.setLabelText(text);
    }
    
    public void isLoggedIn(String token){
        token = this.token;
        if (token == "") {
            mainView.setVisible(false);
            cartView.setVisible(false);
        }
        else {
            String text = "Bejelentkezve";
            mainView.setVisible(true);
            cartView.setVisible(true);
            tab.setLabelText(text);
        }
    }
}
