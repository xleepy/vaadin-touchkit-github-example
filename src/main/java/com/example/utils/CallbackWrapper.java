package com.example.utils;

import io.reactivex.observers.DisposableObserver;


// TODO: write own CallBackwrapper
public abstract class CallbackWrapper<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T t) {
    }

    @Override
    public void onError(Throwable e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
