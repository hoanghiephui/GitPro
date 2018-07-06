/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:40 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 5/11/18 6:34 PM
 *
 */

package com.git.github.ktextensions

import com.git.github.repository.BaseRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

/**
 * Adds the subscription to the upstream [Observable] to the [CompositeDisposable]
 * supplied by a class extending [BaseRepository]. This allows the subscription to be
 * cancelled automatically by the Presenter on Android lifecycle events.
 *
 * @param presenter A class extending [BaseRepository]
 * @param <T>       The type of the upstream [Observable]
 */
fun <T> Observable<T>.addToCompositeDisposable(repository: BaseRepository): Observable<T> =
        this.doOnSubscribe { repository.compositeDisposable.add(it) }

/**
 * Adds the subscription to the upstream [Completable] to the [CompositeDisposable] supplied by a
 * class extending [BaseRepository]. This allows the subscription to be cancelled automatically by
 * the Presenter on Android lifecycle events.
 *
 * @param repository A class extending [BaseRepository]
 */
fun Completable.addToCompositeDisposable(repository: BaseRepository): Completable =
        this.doOnSubscribe { repository.compositeDisposable.add(it) }

/**
 * Adds the subscription to the upstream [Single] to the [CompositeDisposable]
 * supplied by a class extending [BaseRepository]. This allows the subscription to be
 * cancelled automatically by the Presenter on Android lifecycle events.
 *
 * @param presenter A class extending [BaseRepository]
 * @param <T>       The type of the upstream [Single]
</T> */
fun <T> Single<T>.addToCompositeDisposable(presenter: BaseRepository): Single<T> =
        this.doOnSubscribe { presenter.compositeDisposable.add(it) }