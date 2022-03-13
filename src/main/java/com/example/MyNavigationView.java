package com.example;

import com.example.services.SubscribtionBusService;
import com.example.utils.CallbackWrapper;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.vaadin.touchkit.ui.NavigationView;

import java.util.function.Function;

public class MyNavigationView extends NavigationView {

    private final SubscribtionBusService subscribtionBusService = SubscribtionBusService.getInstance();

    public <T> void subscribe(Observable<T> observable, Function<T, Void> function) {
        Disposable disposable = observable.subscribeOn(Schedulers.computation()).subscribeWith(new CallbackWrapper<T>() {
            @Override
            public void onNext(T o) {
                super.onNext(o);
                getUI().accessSynchronously(() -> {
                    function.apply(o);
                });
            }
        });
        subscribtionBusService.subscribe(disposable);
    }

}
