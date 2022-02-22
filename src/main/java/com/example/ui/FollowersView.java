package com.example.ui;

import com.example.MyNavigationView;
import com.example.data.models.User;
import com.example.ui.user.UserProfile;
import com.example.utils.CallbackWrapper;
import com.vaadin.event.LayoutEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

import java.util.List;

public class FollowersView extends MyNavigationView {
    VerticalComponentGroup content = new VerticalComponentGroup();
    private final Observable<List<User>> users;

    public FollowersView(String caption,Observable<List<User>> users) {
        setCaption(caption);
        setContent(content);
        this.users = users;
    }

    @Override
    protected void onBecomingVisible() {
        super.onBecomingVisible();
        System.out.println("here");
        VerticalComponentGroup content = new VerticalComponentGroup();
        Disposable disposable = users.subscribeWith(new CallbackWrapper<List<User>>() {
            @Override
            public void onNext(@NonNull List<User> followers) {
                getUI().access(() -> {
                    for (User follower : followers) {
                        content.addComponent(createGridLayout(follower));
                    }
                });
            }
        });
        compositeDisposable.add(disposable);
        CssLayout cssLayout = new CssLayout(content);
        cssLayout.setStyleName("form");
        setContent(cssLayout);
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
