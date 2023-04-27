package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Product;
import models.restApi.RestApi;

public class MainView extends VBox {
    Label prodLabel;
    RestApi restapi = new RestApi();
    TableView<Product> tableView;
    ObservableList<Product> selectedProducts;


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

        tableView.setItems(this.getProducts());

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(catgCol);
        tableView.getColumns().add(brandCol);
        tableView.getColumns().add(descriptCol);
        tableView.getColumns().add(priceCol);

    }

    private ObservableList<Product> getProducts() {
        ObservableList<Product> productList = FXCollections.observableArrayList(restapi.getProducts());
        return productList;
    }

    
    public ObservableList<Product> getData(){

        ObservableList<Product> selectedProducts = FXCollections.observableArrayList();

        tableView.setRowFactory(tv -> {
            TableRow<Product> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {

                    Product selectedProduct = row.getItem();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Selected Product");
                    alert.setHeaderText(null);
                    alert.setContentText("You have selected: " + selectedProduct.getName());

                    ButtonType addToListBtn = new ButtonType("Kosárba");
                    ButtonType closeBtn = new ButtonType("OK");

        
                    alert.getButtonTypes().setAll(addToListBtn, closeBtn);
        
                    Button addToListButton = (Button) alert.getDialogPane().lookupButton(addToListBtn);
                    addToListButton.setOnAction(e -> {
                        selectedProducts.add(selectedProduct);
                    });
        
                }
            });
            return row;
        });
        return selectedProducts;
    }
}
