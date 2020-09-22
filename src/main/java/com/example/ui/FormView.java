package com.example.ui;

import com.example.ui.user.UserProfile;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickListener;
import org.vaadin.touchkit.ui.*;
@SuppressWarnings("serial")
public class FormView extends NavigationView {

    FormView() {
        setCaption("Form");
        VerticalComponentGroup content = new VerticalComponentGroup();

        TextField nameField = new TextField();
        Button submitButton = new Button("Submit");

        nameField.setPlaceholder("Enter user nickname... ");

        submitButton.addClickListener((ClickListener) event -> {
            if(nameField.getValue() != null) {
                getNavigationManager().navigateTo(new UserProfile(nameField.getValue()));
            }
        });
        content.addComponent(nameField);

        CssLayout cssLayout = new CssLayout(content, submitButton);
        cssLayout.setStyleName("form");
        setContent(cssLayout);

    }
}
