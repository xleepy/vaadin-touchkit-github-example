package com.example.ui;

import com.example.MyNavigationView;
import com.example.data.models.User;
import com.example.data.remote.stores.UsersStore;
import com.example.ui.user.UserProfile;
import com.example.utils.CallbackWrapper;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import io.reactivex.disposables.Disposable;
import org.vaadin.touchkit.ui.*;

import java.util.List;

@SuppressWarnings("serial")
public class MenuView extends MyNavigationView {
    private final UsersStore usersStore = new UsersStore();
    public MenuView()
    {
        setCaption("Menu");
    }

    @Override
    protected void onBecomingVisible() {
        super.onBecomingVisible();
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

        Disposable disposable = usersStore.getUsers().subscribeWith(new CallbackWrapper<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                getUI().access(() -> {
                    for(User user : users) {
                        grid.addComponent(createUserPreview(user));
                    }
                });
            }
        });
        content.addComponent(grid);
        compositeDisposable.add(disposable);
    }

    private VerticalLayout createUserPreview(User user){
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
