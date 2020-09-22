package com.example.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private Number id;
    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("public_repos")
    @Expose
    private Number publicReposNumber;

    @SerializedName("followers")
    @Expose
    private Number followersNumber;

    @SerializedName("following")
    @Expose
    private Number followingNumber;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("blog")
    @Expose
    private String blog;

    @SerializedName("company")
    @Expose
    private String company;

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getBio(){
        return bio;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Number getPublicReposNumber() {
        return publicReposNumber;
    }

    public void setPublicReposNumber(Number publicReposNumber) {
        this.publicReposNumber = publicReposNumber;
    }

    public Number getFollowersNumber() {
        return followersNumber;
    }

    public void setFollowersNumber(Number followersNumber) {
        this.followersNumber = followersNumber;
    }

    public Number getFollowingNumber() {
        return followingNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getBlog() {
        return blog;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "{ \n" +
                "user id: " + id +
                "\n name: " + name +
                "\n location: " + location +
                "\n bio: " + bio +
                "\n user login:" + login +
                "\n avatar_url:" + avatarUrl +
                "\n email: " + email +
                "\n company: " + company +
                "\n}";
    }
}
