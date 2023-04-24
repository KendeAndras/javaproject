package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Product;
import models.restApi.RestApi;

public class MainView extends VBox {
    Label prodLabel;
    RestApi restapi;
    TableView<Product> tableView;

    public MainView() {
        prodLabel = new Label("Termékek");
    
        this.createTable();
        this.getChildren().add(prodLabel);
        this.getChildren().add(tableView);

    }
    private void createTable() {
        tableView = new TableView<>();
        
        TableColumn<Product, Integer> idCol = new TableColumn<>("Azonosító");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<Product, String> nameCol = new TableColumn<>("Név");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Product, String> catgCol = new TableColumn<>("Kategória");
        catgCol.setMinWidth(60);
        catgCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Product, String> brandCol = new TableColumn<>("Márka");
        brandCol.setMinWidth(60);
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Product, String> descriptCol = new TableColumn<>("Leírás");
        descriptCol.setMinWidth(100);
        descriptCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        TableColumn<Product, Double> priceCol = new TableColumn<>("Ár");
        priceCol.setMinWidth(60);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        //TODO image column(imgCol)

        tableView.setItems(this.getProducts());

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(catgCol);
        tableView.getColumns().add(brandCol);
        tableView.getColumns().add(descriptCol);
        tableView.getColumns().add(priceCol);
        //tableView.getColumns().add(imgCol);
        
    }

    private ObservableList<Product> getProducts() {
        ObservableList<Product> productList = 
        FXCollections.observableArrayList(restapi.getProducts());
        return productList;
    }
}
