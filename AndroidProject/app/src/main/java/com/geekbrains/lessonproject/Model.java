package com.geekbrains.lessonproject;

import android.annotation.SuppressLint;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class Model {
    private Observable<String> observable;

    public Observable<String> getObservable() {
        return observable;
    }

    @SuppressLint("CheckResult")
    public Model() {
        observable = Observable.<String>create(emitter -> {
            for (int i = 0; i < 5; i++) {
                emitter.onNext("Pavlik");
                TimeUnit.SECONDS.sleep(1);
            }
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).publish().refCount();
    }
}
