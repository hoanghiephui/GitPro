/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:05 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:05 PM
 *
 */

package com.git.github.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.git.github.dl.Injectable
import com.git.github.ktextensions.unsafeLazy
import com.git.github.rxjava.events.EventsBus
import io.reactivex.Observable
import javax.inject.Inject

abstract class BaseFragment: Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val loadDataEventObservable: Observable<EventsBus> by unsafeLazy {
        baseActivity().rxBus.register(EventsBus::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(initLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.configureLogic()
        this.configureViewModel()
        onListenRxBus()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onDestroyViews()
        baseActivity().rxBus.unregister(EventsBus::class.java, loadDataEventObservable)
    }

    /**
     * @method add id layout to view
     * @return [Int] id layout
     */
    abstract fun initLayout(): Int

    /**
     * @method init view
     * @param view
     */
    abstract fun initView(view: View)

    /**
     * @method config dagger
     */
    abstract fun configureLogic()

    /**
     * @method config view model
     */
    abstract fun configureViewModel()

    abstract fun onDestroyViews()

    open fun onListenRxBus() {}

    fun baseActivity(): BaseActivity {
        return activity as BaseActivity
    }
}
