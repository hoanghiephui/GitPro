/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:20 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:20 PM
 *
 */

package com.git.github.dl.module

import com.git.github.MainActivity
import com.git.github.ui.BaseActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeBaseActivity(): BaseActivity

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}