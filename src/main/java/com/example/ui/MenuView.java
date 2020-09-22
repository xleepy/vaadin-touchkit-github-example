package com.example.ui;

import com.example.MyNavigationView;
import com.example.data.models.User;
import com.example.data.remote.stores.UsersStore;
import com.example.ui.user.UserProfile;
import com.example.utils.CallbackWrapper;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import io.reactivex.disposables.CompositeDisposable;
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
        Disposable disposable = usersStore.getUsers().subscribeWith(new CallbackWrapper<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                    for(User user : users) {
                        content.addComponent(createGridLayout(user));
                    }
            }
        });
        compositeDisposable.add(disposable);
    }

    private GridLayout createGridLayout(User follower){
        GridLayout grid = new GridLayout(1, 7);
        grid.setWidth("100%");
        grid.addComponent(new Label("User name:  " + follower.getLogin()), 0, 0);
        grid.addLayoutClickListener((LayoutEvents.LayoutClickListener) layoutClickEvent -> {
            getNavigationManager().navigateTo(new UserProfile(follower.getLogin()));
        });
        Image avatar = new Image("User avatar", new ExternalResource(follower.getAvatarUrl()));
        avatar.setWidth("100px");
        avatar.setHeight("100px");
        grid.addComponent(avatar, 0, 6);
        return grid;
    }

}
