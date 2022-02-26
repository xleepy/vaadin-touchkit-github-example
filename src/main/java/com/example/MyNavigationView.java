package com.example;

import com.example.utils.CallbackWrapper;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.vaadin.touchkit.ui.NavigationView;
import io.reactivex.Observable;

import java.util.function.Function;

public class MyNavigationView extends NavigationView {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public <T> void subscribe(Observable<T> observable, Function<T, Void> function) {
        Disposable disposable = observable.subscribeOn(Schedulers.io()).subscribeWith(new CallbackWrapper<T>() {
            @Override
            public void onNext(T o) {
                super.onNext(o);
                getUI().accessSynchronously(() -> {
                    function.apply(o);
                });
            }
        });
        compositeDisposable.add(disposable);
    }

    @Override
    public void detach() {
        super.detach();
        compositeDisposable.dispose();
    }
}
