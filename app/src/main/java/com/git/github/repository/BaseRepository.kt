/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:40 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:40 PM
 *
 */

package com.git.github.repository

import io.reactivex.disposables.CompositeDisposable

abstract class BaseRepository {
    val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    fun onViewDestroyed() {
        /* Clear all subscriptions so that:
         * 1) all processes are cancelled
         * 2) processes don't try to update a null BaseView
         * 3) background processes don't leak memory
         */
        compositeDisposable.clear()

        /*
         * Clear PresenterComponent, thereby releasing all objects with a
         */
        //Injector.getInstance().releaseViewModelScope()
    }
}