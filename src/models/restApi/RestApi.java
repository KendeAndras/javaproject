package models.restApi;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Product;

public class RestApi {

    public RestApi() {
    }

    public String getProductsAsString() {

        String host = "http://localhost:8000/api/";
        String endpoint = "products";
        String urlStr = host + endpoint;
        HttpClient http = new HttpClient();
        String res = http.get(urlStr);
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
}
