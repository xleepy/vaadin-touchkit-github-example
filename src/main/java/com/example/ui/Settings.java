package com.example.ui;

import com.example.MyNavigationView;
import com.vaadin.ui.*;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

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
        content.addComponent(upload);
        CssLayout cssLayout = new CssLayout(content);
        cssLayout.setStyleName("settings");
        setContent(cssLayout);
    }

}
