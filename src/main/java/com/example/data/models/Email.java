package com.example.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Email {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("primary")
    @Expose
    private Boolean primary;

    @SerializedName("verified")
    @Expose
    private Boolean verified;

    @SerializedName("visibility")
    @Expose
    private String visibility;


    public String getEmail() {
        return email;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public Boolean getVerified() {
        return verified;
    }

    public String getVisibility() {
        return visibility;
    }
}
