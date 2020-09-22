package com.example.ui;

import com.example.data.models.User;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public class Helpers {

    public static CustomLayout createBasicInfoLayout(User user) {
        CustomLayout customLayout = new CustomLayout("userprofile");
        customLayout.setHeightUndefined();
        customLayout.setWidth("100%");
        customLayout.addComponent(new Label("Username: " + user.getName()), "username");
        if(user.getEmail() != null) {
            customLayout.addComponent(new Label("Email: " + user.getEmail()), "email");
        }
        if(user.getBio() != null) {
            customLayout.addComponent(new Label("Bio: " + user.getBio()), "bio");
        }
        if(user.getLocation() != null) {
            customLayout.addComponent(new Label("Location: " + user.getLocation()), "location");
        }
        if(user.getCompany() != null) {
            customLayout.addComponent(new Label("Company: " + user.getCompany()), "company");
        }
        Image avatar = new Image();
        avatar.setSource(new ExternalResource(user.getAvatarUrl()));
        customLayout.addComponent(avatar, "avatar");
        return customLayout;
    }
}
