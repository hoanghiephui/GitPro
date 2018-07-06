/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:21 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:21 PM
 *
 */

package com.git.github.dl.component

import android.app.Application
import com.git.github.GithubApp
import com.git.github.dl.module.ActivityBindingModule
import com.git.github.dl.module.ApiModule
import com.git.github.dl.module.ApplicationModule
import com.git.github.dl.module.DataManagerModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            ApplicationModule::class,
            ActivityBindingModule::class,
            ApiModule::class,
            DataManagerModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(githubApp: GithubApp)
}