/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:45 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 5/21/18 12:38 PM
 *
 */

package com.git.github.rxjava;

import android.util.Log;


import com.git.github.repository.BaseRepository;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hoanghiep on 3/19/18.
 * A class for basic RxJava utilities, ie Transformer classes
 */

public class RxUtil {
    private static final String TAG = RxUtil.class.getSimpleName();

    /**
     * Applies standard Schedulers to an {@link Observable}, ie IO for subscription, Main Thread for
     * onNext/onTokenComplete/onError
     */
    public static <T> ObservableTransformer<T, T> applySchedulersToObservable() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e(TAG, "applySchedulersToObservable: ", throwable));
    }

    public static <T> ObservableTransformer<T, T> applySchedulersComputationToObservable() {
        return observable -> observable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e(TAG, "applySchedulersToObservable: ", throwable));
    }

    /**
     * Applies standard Schedulers to a {@link Single}, ie IO for subscription, Main Thread for
     * onNext/onTokenComplete/onError
     */
    public static <T> SingleTransformer<T, T> applySchedulersToSingle() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e(TAG, "applySchedulersToObservable: ", throwable));
    }

    public static <T> FlowableTransformer<T, T> applySchedulersToFlowable() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Applies standard Schedulers to a {@link io.reactivex.Completable}, ie IO for subscription,
     * Main Thread for onNext/onTokenComplete/onError
     */
    public static CompletableTransformer applySchedulersToCompletable() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e(TAG, "applySchedulersToObservable: ", throwable));
    }

    /**
     * Allows you to call two different {@link Observable} objects based on result of a predicate.
     */
    public static <T, R> Function<? super T, ? extends Observable<? extends R>> ternary(
            Function<T, Boolean> predicate,
            Function<? super T, ? extends Observable<? extends R>> ifTrue,
            Function<? super T, ? extends Observable<? extends R>> ifFalse) {
        return (item) -> predicate.apply(item)
                ? ifTrue.apply(item)
                : ifFalse.apply(item);
    }

    /**
     * Adds the subscription to the upstream {@link Observable} to the {@link CompositeDisposable}
     * supplied by a class extending {@link BaseRepository}. This allows the subscription to be
     * cancelled automatically by the Presenter on Android lifecycle events.
     *
     * @param presenter A class extending {@link BaseRepository}
     * @param <T>       The type of the upstream {@link Observable}
     */
    public static <T> ObservableTransformer<T, T> addObservableToCompositeDisposable(BaseRepository presenter) {
        return upstream -> upstream.doOnSubscribe(disposable ->
                presenter.getCompositeDisposable().add(disposable));
    }

    /**
     * Adds the subscription to the upstream {@link io.reactivex.Completable} to the {@link
     * CompositeDisposable} supplied by a class extending {@link BaseRepository}. This allows the
     * subscription to be cancelled automatically by the Presenter on Android lifecycle events.
     *
     * @param presenter A class extending {@link BaseRepository}
     */
    public static CompletableTransformer addCompletableToCompositeDisposable(BaseRepository presenter) {
        return upstream -> upstream.doOnSubscribe(disposable ->
                presenter.getCompositeDisposable().add(disposable));
    }

    /**
     * Adds the subscription to the upstream {@link Single} to the {@link CompositeDisposable}
     * supplied by a class extending {@link BaseRepository}. This allows the subscription to be
     * cancelled automatically by the Presenter on Android lifecycle events.
     *
     * @param presenter A class extending {@link BaseRepository}
     * @param <T>       The type of the upstream {@link Single}
     */
    public static <T> SingleTransformer<T, T> addSingleToCompositeDisposable(BaseRepository presenter) {
        return upstream -> upstream.doOnSubscribe(disposable ->
                presenter.getCompositeDisposable().add(disposable));
    }
}
