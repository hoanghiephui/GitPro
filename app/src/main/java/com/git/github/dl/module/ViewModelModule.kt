/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 4:07 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 4:07 PM
 *
 */

package com.git.github.dl.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.git.github.FactoryViewModel
import com.git.github.dl.ViewModelKey
import com.git.github.viewmodel.FeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FeedViewModel::class)
    abstract fun binFeedViewModel(feedViewModel: FeedViewModel): ViewModel
}