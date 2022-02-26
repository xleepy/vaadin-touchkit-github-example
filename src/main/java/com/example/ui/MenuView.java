package com.example.ui;

import com.example.MyNavigationView;
import com.example.data.models.User;
import com.example.data.remote.stores.UsersStore;
import com.example.ui.user.UserProfile;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import org.vaadin.touchkit.ui.*;

@SuppressWarnings("serial")
public class MenuView extends MyNavigationView {
    private final UsersStore usersStore = new UsersStore();

    public MenuView() {
        setCaption("Menu");
    }

    @Override
    public void attach() {
        super.attach();
        VerticalComponentGroup content = new VerticalComponentGroup();
        CssLayout cssLayout = new CssLayout(content);
        cssLayout.setStyleName("form");
        setContent(cssLayout);
        NavigationButton button = new NavigationButton("Search user");
        button.addClickListener((NavigationButton.NavigationButtonClickListener) navigationButtonClickEvent -> {
            getNavigationManager().navigateTo(new FormView());
        });
        content.addComponent(button);
        GridLayout grid = new GridLayout();
        grid.setColumns(3);
        grid.setWidth("100%");
        grid.setSpacing(true);
        subscribe(usersStore.getUsers(), (users) -> {
            for (User user : users) {
                grid.addComponent(createUserPreview(user));
            }
            return null;
        });
        content.addComponent(grid);
    }

    private VerticalLayout createUserPreview(User user) {
        VerticalLayout verticalLayout = new VerticalLayout();

        Image avatar = new Image("User avatar", new ExternalResource(user.getAvatarUrl()));
        avatar.setWidth("100px");
        avatar.setHeight("100px");

        verticalLayout.addStyleName("grid-cell");

        verticalLayout.addComponent(new Label("User name:  " + user.getLogin()));
        verticalLayout.addComponent(avatar);
        verticalLayout.addLayoutClickListener((LayoutEvents.LayoutClickListener) layoutClickEvent -> {
            getNavigationManager().navigateTo(new UserProfile(user.getLogin()));
        });
        return verticalLayout;
    }
}
