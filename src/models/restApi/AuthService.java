package models.restApi;

import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AuthService {
    String host = "http://localhost:8000/api/";

    public AuthService() {
    }

    public void registry(String name, String email, String pass, String passC) {
        String enpoint = "register";
        String url = this.host + enpoint;

        User uData = new User(name, email, pass, passC);
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String jsonData = gson.toJson(uData);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
    
        HttpClient http = new HttpClient();
        String result = http.post(url, jsonData, headers);
        
    }
    
    public void login(){
        String enpoint = "login";
        String url = this.host + enpoint;

            //TODO
    }
}
