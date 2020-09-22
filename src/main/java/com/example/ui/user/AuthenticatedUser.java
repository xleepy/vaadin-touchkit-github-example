package com.example.ui.user;

import com.example.MyNavigationView;
import com.example.data.models.User;
import com.example.data.remote.stores.RepositoriesStore;
import com.example.ui.Helpers;
import com.example.ui.MyBarMenu;
import com.example.utils.CallbackWrapper;
import com.vaadin.ui.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import org.vaadin.touchkit.ui.VerticalComponentGroup;

public class AuthenticatedUser extends MyNavigationView {
    public AuthenticatedUser() {
        setCaption("TODO authenticated user profile");
    }



}
