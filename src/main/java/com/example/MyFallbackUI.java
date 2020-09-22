package com.example;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.vaadin.touchkit.annotations.CacheManifestEnabled;
import org.vaadin.touchkit.annotations.OfflineModeEnabled;

/**
 * This UI is served for browsers that don't support TouchKit.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
// Disable browser caching the app for running it when offline
@CacheManifestEnabled(false)
// Prevent showing OfflineMode client UI if network fails
@OfflineModeEnabled(false)
public class MyFallbackUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(true);
        layout.setMargin(true);

        Button button = new Button("Continue anyway.", new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                getSession().setAttribute("mobile", true);
                getUI().getPage().reload();
            }
        });
        button.addStyleName("link");

        layout.addComponent(new Label("You seem to be using a desktop browser."));
        layout.addComponent(button);

        setContent(layout);
    }

}
