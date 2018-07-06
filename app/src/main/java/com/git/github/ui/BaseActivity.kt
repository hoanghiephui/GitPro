/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:52 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:52 PM
 *
 */

package com.git.github.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.git.github.R
import com.git.github.rxjava.RxBus
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var rxBus: RxBus
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ThemeLight)
        super.onCreate(savedInstanceState)
        setContentView(initLayout())
        configureLogic(savedInstanceState)
        setEvents()
    }

    abstract fun initLayout(): Int

    abstract fun configureLogic(savedInstanceState: Bundle?)

    abstract fun setEvents()

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}