package com.example.ui;

import com.example.data.models.User;
import com.example.data.remote.stores.RepositoriesStore;
import com.example.data.remote.stores.UserStore;
import com.example.ui.repository.RepositoriesView;
import com.vaadin.ui.MenuBar;
import org.vaadin.touchkit.ui.NavigationManager;

import java.util.Formatter;

public class MyBarMenu extends MenuBar {
    public MyBarMenu(
            User user,
            NavigationManager navigationManager,
            UserStore userStore,
            RepositoriesStore repositoriesStore
    ) {
        Formatter formatter = new Formatter();
        String followersTitle = formatter.format("Followers (%s)", user.getFollowersNumber()).toString();
        addItem(followersTitle, (MenuBar.Command) menuItem -> {
            navigationManager.navigateTo(new FollowersView("Followers", userStore.getFollowers(user.getLogin())));
        });
        addItem(String.format("Following %s", user.getFollowingNumber()), (MenuBar.Command) menuItem -> {
            navigationManager.navigateTo(new FollowersView("Following" ,userStore.getFollowing(user.getLogin())));
        });
        addItem(String.format("Public repos %s", user.getPublicReposNumber()), (MenuBar.Command) menuItem -> {
            navigationManager.navigateTo(new RepositoriesView("Repositories", repositoriesStore.getRepositories(user.getLogin())));
        });
        addItem("Subscriptions", (MenuBar.Command) menuItem -> {
            navigationManager.navigateTo(new RepositoriesView("Subscriptions", repositoriesStore.getSubscriptions(user.getLogin())));
        });
        addStyleName("bar-menu");
    }
}
