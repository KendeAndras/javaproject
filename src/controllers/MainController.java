package controllers;

import models.Product;
import views.MainView;
import views.Tabs;

public class MainController {

    MainView mainView;
    Tabs tab;
    Product product;
    Product soldProd;

    public MainController() {
        this.mainView = new MainView();
        this.tab = new Tabs(this.mainView);
        
    }

    public Tabs getTab() {
        return this.tab;
    }

    public Product addToCart(Product product) {
        //TODO (incoming products going first here)
        product = this.product;
        return product;
    }

    public void buyProduct(){
        soldProd = this.addToCart(product);
        // TODO handle output product
    }
    
}
