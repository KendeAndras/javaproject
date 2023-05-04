package models.restApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.Product;
import views.Tabs;

public class RestApi {
    Tabs tab;

    public RestApi() {
    }

    public String getProductsAsString() {
        String host = "http://localhost:8000/api/";
        String endpoint = "Products";
        String urlStr = host + endpoint;
        HttpClient http = new HttpClient();
        String res = null;
        try {
            res = http.get(urlStr);
        } catch (Exception e) {
            System.err.println("Hiba, nincs Server");
        }
        return res;
    }
    

    public ArrayList<Product> getProducts() {
        
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getProductsAsString();
        Product[] productArray =  gson.fromJson(text, Product[].class);
        ArrayList<Product> productList = new ArrayList<>(Arrays.asList(productArray));
        return productList;
    }

    public void productsBought(List<Integer> list) {
        String host = "http://localhost:8000/api/";
        String endpoint = "delete";
        String urlStr = host + endpoint;
    
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
    
        HttpClient http = new HttpClient();
        for (Integer productId : list) {
            try {
                String jsonData = "{\"id\": " + productId.toString() + "}";
                http.post(urlStr, jsonData, headers);
            } catch (Exception e) {
                String text = "Sikertelen Vásárlás";
                tab.setLabelText(text);
            }
        }
    }
    
}
