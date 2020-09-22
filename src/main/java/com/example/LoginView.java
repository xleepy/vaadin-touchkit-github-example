package com.example;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

@Theme("mytheme")
@PreserveOnRefresh
@Widgetset("com.example.gwt.MyWidgetSet")
public class LoginView extends UI {
    @Override
    protected void init(VaadinRequest request) {
        VerticalComponentGroup componentGroup = new VerticalComponentGroup();
        TextField username = new TextField("Username");
        PasswordField passwordField = new PasswordField("Password");
        Button loginButton = new Button("Login");

        loginButton.addClickListener(event -> {
            MyTouchKitUI myTouchKitUI = new MyTouchKitUI();
            myTouchKitUI.init(request);
            getSession().addUI(myTouchKitUI);
        });
        componentGroup.addComponents(username, passwordField, loginButton);
        setContent(componentGroup);
    }
}
