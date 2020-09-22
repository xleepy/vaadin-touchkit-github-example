package com.example.data.models.edit;

public class UserData {
    private String name;
    private String email;
    private String blog;
    private String company;
    private String location;
    private String bio;
    public UserData(String userName, String userEmail, String userBlogUrl, String userCompany, String userLocation, String userBio){
        name = userName;
        email = userEmail;
        blog = userBlogUrl;
        company = userCompany;
        location = userLocation;
        bio = userBio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
