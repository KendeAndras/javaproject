package views;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
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

    public CartView(){}

    public CartView(ObservableList<Product> productList) {
        cartLabel = new Label("Kosár");

        this.productList = productList;
        this.addSelectedProducts(tableView);
        this.createTable();
        this.getChildren().add(cartLabel);
        this.getChildren().add(tableView);
    }


    public ObservableList<Product> addSelectedProducts(TableView<Product> tableView) {
        for (Product product : tableView.getSelectionModel().getSelectedItems()) {
            productList.add(product);
        }
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

    public List<Integer> buy() {
        List<Integer> selectedIds = new ArrayList<>();
        for (Product product : productList) {
            selectedIds.add(product.getId());
        }
        return selectedIds;
    }
    
}

