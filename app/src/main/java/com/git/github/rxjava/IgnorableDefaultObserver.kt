/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:46 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 3/28/18 8:44 AM
 *
 */

package com.git.github.rxjava

import android.util.Log

import io.reactivex.CompletableObserver
import io.reactivex.observers.DefaultObserver

/**
 * Created by hoanghiep on 3/19/18.
 * To be used when the result of the subscription can be ignored
 */

class IgnorableDefaultObserver<T> : DefaultObserver<T>(), CompletableObserver {

    override fun onComplete() {
        // No-op
    }

    override fun onError(e: Throwable) {
        Log.e(TAG, "onError: ", e)
    }

    override fun onNext(t: T) {
        // No-op
    }

    companion object {
        private val TAG = IgnorableDefaultObserver::class.java.simpleName
    }
}
