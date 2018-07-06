/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:45 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 4/3/18 10:39 PM
 *
 */

package com.git.github.rxjava;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by hoanghiep on 3/19/18.
 */

public final class RxLambdas {

    // For collapsing into Lambdas
    public interface ObservableRequest<T> {
        Observable<T> apply();
    }

    // For collapsing into Lambdas
    public interface CompletableRequest {
        Completable apply();
    }

    public abstract static class ObservableFunction<T> implements Function<Void, Observable<T>> {
        public abstract Observable<T> apply(Void empty);
    }

    public abstract static class CompletableFunction implements Function<Void, Completable> {
        public abstract Completable apply(Void empty);
    }

}
