package com.example.ui;

import com.example.data.models.User;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;

public class Helpers {

    private static void addPropertyIfExists(CustomLayout customLayout, String key, Object property) {
        if(property != null) {
            customLayout.addComponent(new Label(key + ": " + property), key);
        }
    }

    public static CustomLayout createBasicInfoLayout(User user) {
        CustomLayout customLayout = new CustomLayout("userprofile");
        customLayout.setHeightUndefined();
        customLayout.setWidth("100%");
        customLayout.addComponent(new Label("Username: " + user.getName()), "username");
        addPropertyIfExists(customLayout,"Username", user.getName());
        addPropertyIfExists(customLayout, "Email", user.getEmail());
        addPropertyIfExists(customLayout, "Bio", user.getBio());
        addPropertyIfExists(customLayout, "Location", user.getLocation());
        addPropertyIfExists(customLayout, "Company", user.getCompany());
        Image avatar = new Image();
        avatar.setSource(new ExternalResource(user.getAvatarUrl()));
        customLayout.addComponent(avatar, "avatar");
        return customLayout;
    }
}
