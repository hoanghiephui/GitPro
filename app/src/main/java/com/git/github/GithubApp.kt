/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:22 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:22 PM
 *
 */

package com.git.github

import android.app.Activity
import android.app.Application
import com.git.github.api.FrameworkInterface
import com.git.github.api.GitHubFramework
import com.git.github.dl.AppInjector
import dagger.Lazy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import retrofit2.Retrofit
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject
import javax.inject.Named

class GithubApp: Application(), HasActivityInjector, FrameworkInterface {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @field:[Inject Named("api")]
    lateinit var retrofitApi: Lazy<Retrofit>
    override fun onCreate() {
        super.onCreate()
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SFUIText-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )

        // Inject into Application
        AppInjector.init(this)
        GitHubFramework.init(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun getRetrofitApiInstance(): Retrofit {
        return retrofitApi.get()
    }
}