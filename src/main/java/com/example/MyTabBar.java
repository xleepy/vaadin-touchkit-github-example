package com.example;

import com.example.ui.MenuView;
import com.example.ui.Settings;
import com.example.ui.Feed;
import com.example.ui.user.AuthenticatedUser;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import org.vaadin.touchkit.ui.NavigationManager;
import org.vaadin.touchkit.ui.TabBarView;

public class MyTabBar extends TabBarView implements View {
    public MyTabBar() {
        Component menuTab = createTab(new MenuView(), FontAwesome.USERS, "Users");
        addTab(menuTab);
        addTab(createTab(new Settings(), FontAwesome.TRASH, "Settings"));
        addTab(createTab(new AuthenticatedUser(), FontAwesome.USER, "User profile"));
        addTab(createTab(new Feed(), FontAwesome.FEED, "Feed"));
        setSelectedTab(menuTab);
    }
    private Component createTab(final Component component, FontAwesome icon, String caption) {
        final NavigationManager navigationComponent = new NavigationManager(component);
        System.out.println(navigationComponent.getComponentCount());
        navigationComponent.setIcon(icon);
        navigationComponent.setCaption(caption);
        return navigationComponent;
    }
}
