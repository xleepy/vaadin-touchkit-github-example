package com.example.ui;

import com.example.MyNavigationView;
import com.example.data.remote.Credentials;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

import java.util.Base64;

@SuppressWarnings("serial")
public class Settings extends MyNavigationView {
    TextField email = new TextField("Email");
    Link link = new Link();

    public Settings() {
        setCaption("Settings");
    }

    @Override
    public void attach() {
        super.attach();
        link.setTargetName("link to github");
        link.setResource(new ExternalResource("https://github.com/login/oauth/authorize?scope=" + email.getValue() + "&client_id=" + Credentials.getInstance().getClientId()));
        VerticalComponentGroup content = new VerticalComponentGroup();
        final Button submitBtn = new Button("Login");
        Upload upload = new Upload("Upload it here", (Upload.Receiver) (filename, mimeType) -> null);
        upload.setImmediateMode(false);
        Button logout = new Button("Reload ui");
        content.addComponents(submitBtn, logout, upload, link);
        CssLayout cssLayout = new CssLayout(content);
        cssLayout.setStyleName("settings");

        setContent(cssLayout);
    }

}
