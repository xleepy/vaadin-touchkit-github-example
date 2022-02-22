package com.example.ui;

import com.example.MyNavigationView;
import com.example.data.remote.Credentials;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

import java.util.Base64;

@SuppressWarnings("serial")
public class Settings extends MyNavigationView {

    public Settings() {
        setCaption("Settings");
    }

    @Override
    public void attach() {
        super.attach();
        VerticalComponentGroup content = new VerticalComponentGroup();
        Upload upload = new Upload("Upload it here", (Upload.Receiver) (filename, mimeType) -> null);
        upload.setImmediateMode(false);
        Button logout = new Button("Reload ui");
        CssLayout cssLayout = new CssLayout(content);
        cssLayout.setStyleName("settings");

        setContent(cssLayout);
    }

}
