package com.example;

import io.reactivex.disposables.CompositeDisposable;
import org.vaadin.touchkit.ui.NavigationView;

public class MyNavigationView extends NavigationView {

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public void detach() {
        super.detach();
        compositeDisposable.dispose();
    }
}
