package com.example.services;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class SubscribtionBusService {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private static SubscribtionBusService instance = null;


    public static SubscribtionBusService getInstance() {
        if (instance == null) {
            instance = new SubscribtionBusService();
        }
        return instance;
    }

    public void subscribe(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public void unsubscribeAll() {
        System.out.println("unsubscribe all");
        compositeDisposable.clear();
    }
}
