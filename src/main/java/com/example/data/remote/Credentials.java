package com.example.data.remote;

public class Credentials {
    public static Credentials instance;

    private String clientId;
    private String clientSecret;
    private String token;
    public static final String USER_AGENT = "my-app";
    public static final String MEDIA_TYPE = "github.v3; param=full; format=json";

    public static Credentials getInstance() {
        if (instance == null) {
            instance = new Credentials();
        }
        return instance;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
