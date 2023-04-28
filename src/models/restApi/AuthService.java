package models.restApi;

import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AuthService {
    String host = "http://localhost:8000/api/";
    String result;

    public AuthService() {
    }

    public String registry(String name, String email, String pass, String passC) {
        String endpoint = "register";
        String url = this.host + endpoint;

        User uData = new User(name, email, pass, passC);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonData = gson.toJson(uData);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        HttpClient http = new HttpClient();
        return this.result = http.post(url, jsonData, headers);

    }

    public String login(String name, String pass) {
        String endpoint = "login";
        String url = this.host + endpoint;

        User uData = new User(name, pass);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonData = gson.toJson(uData);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");

        HttpClient http = new HttpClient();
        return this.result = http.post(url, jsonData, headers);

    }
  
}
