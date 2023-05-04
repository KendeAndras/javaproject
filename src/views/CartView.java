package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import controllers.MainController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Product;

public class CartView extends VBox {
    MainView mainView = new MainView();
    private ObservableList<Product> productList;
    TableView<Product> tableView;
    Label cartLabel;
    String text;
    ArrayList<Integer> selectedIds;
    Button button = new Button();

    public CartView(){
        cartLabel = new Label("Kosár");

        this.addSelectedProducts(tableView);
        this.createTable();
        this.getChildren().add(cartLabel);
        this.getChildren().add(tableView);
        this.getChildren().add(button);
        this.setTextToButton();
        this.setButtonAction();
    }

    public CartView(ObservableList<Product> productList) {
        this.productList = productList;
    }


    public ObservableList<Product> addSelectedProducts(TableView<Product> tableView) {
        ObservableList<Product> productList = FXCollections.observableArrayList(mainView.getSelectedItems());
        return productList;
    }

    public void createTable(){
        
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

        tableView.setItems(this.addSelectedProducts(tableView));

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(catgCol);
        tableView.getColumns().add(brandCol);
        tableView.getColumns().add(descriptCol);
        tableView.getColumns().add(priceCol);
    }

    public void boughtProducts() {
        this.selectedIds = new ArrayList<>();
        for (Product product : productList) {
            selectedIds.add(product.getId());
        }
    }
    
    private void setTextToButton() {
        this.text = "Vásárlás";
        button.setText(text);
    }

    private void setButtonAction() {
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent aEvent) {
                MainController mainController = new MainController();
                boughtProducts();
                mainController.buyProduct(selectedIds);
            }
        });
    }
}

