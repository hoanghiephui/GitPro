/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:56 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:56 PM
 *
 */

package com.git.github.dl.module

import com.git.github.ui.fragments.FeedsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeFeedsFragment(): FeedsFragment
}