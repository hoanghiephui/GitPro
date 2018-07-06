/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:27 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:27 PM
 *
 */

package com.git.github.dl

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.git.github.GithubApp
import com.git.github.dl.component.ApplicationComponent
import com.git.github.dl.component.DaggerApplicationComponent
import com.git.github.utils.ApplicationLifeCycle
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

object AppInjector {
    lateinit var applicationComponent: ApplicationComponent
    fun init(githubApp: GithubApp) {
        applicationComponent = DaggerApplicationComponent.builder()
                .application(githubApp)
                .build()
        applicationComponent.inject(githubApp)

        githubApp
                .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                        handleActivity(activity)
                    }

                    override fun onActivityStarted(activity: Activity) {

                    }

                    override fun onActivityResumed(activity: Activity) {
                        ApplicationLifeCycle.getInstance().onActivityResumed()
                    }

                    override fun onActivityPaused(activity: Activity) {
                        ApplicationLifeCycle.getInstance().onActivityPaused()
                    }

                    override fun onActivityStopped(activity: Activity) {

                    }

                    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

                    }

                    override fun onActivityDestroyed(activity: Activity) {

                    }
                })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, fragment: Fragment,
                                                       savedInstanceState: Bundle?) {
                            if (fragment is Injectable) {
                                AndroidSupportInjection.inject(fragment)
                            }
                        }
                    }, true)
        }
    }
}