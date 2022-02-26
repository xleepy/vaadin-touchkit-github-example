package com.example.ui.user;

import com.example.MyNavigationView;
import com.example.data.models.User;
import com.example.data.remote.stores.RepositoriesStore;
import com.example.data.remote.stores.UserStore;
import com.example.ui.Helpers;
import com.example.ui.MyBarMenu;
import com.vaadin.ui.*;
import org.vaadin.touchkit.ui.*;


@SuppressWarnings("serial")
public class UserProfile extends MyNavigationView {
    private final UserStore userStore = new UserStore();
    private final RepositoriesStore repositoriesStore = new RepositoriesStore();
    private final String login;
    public UserProfile(String userLogin) {
        login = userLogin;
    }

    private void createUserPreview(VerticalComponentGroup componentGroup, User user) {
        componentGroup.addComponent(new MyBarMenu(
                user,
                getNavigationManager(),
                userStore,
                repositoriesStore
        ));
        componentGroup.addComponent(Helpers.createBasicInfoLayout(user));
    }

    @Override
    public void attach() {
        super.attach();
        VerticalComponentGroup content = new VerticalComponentGroup();
        setContent(new CssLayout(content));
        subscribe(userStore.loadUser(login), (user) -> {
            createUserPreview(content, user);
            return null;
        });
    }
}
