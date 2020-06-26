package de.wazed.wrapper.generation;

import java.util.HashMap;
import java.util.List;

public class Account {

    private String token;
    private String password;
    private String username;
    private boolean limit;
    private HashMap<String,String> info;

    public Account(String token, String password, String username, boolean limit, HashMap<String,String> info) {
        this.token = token;
        this.password = password;
        this.username = username;
        this.limit = limit;
        this.info = info;
    }

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLimit() {
        return limit;
    }

    public HashMap<String,String> getInfo() {
        return info;
    }
}
