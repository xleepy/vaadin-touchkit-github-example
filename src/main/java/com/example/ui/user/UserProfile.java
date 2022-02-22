package com.example.ui.user;

import com.example.MyNavigationView;
import com.example.data.models.User;
import com.example.data.remote.stores.RepositoriesStore;
import com.example.data.remote.stores.UserStore;
import com.example.ui.Helpers;
import com.example.ui.MyBarMenu;
import com.example.utils.CallbackWrapper;
import com.vaadin.ui.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
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
    protected void onBecomingVisible() {
        super.onBecomingVisible();
        VerticalComponentGroup content = new VerticalComponentGroup();
        setContent(new CssLayout(content));
        Disposable disposable = userStore.loadUser(login)
                .subscribeWith(new CallbackWrapper<User>()  {
                    @Override
                    public void onNext(@NonNull User user) {
                        createUserPreview(content, user);
                    }
                });
        compositeDisposable.add(disposable);
    }
}
