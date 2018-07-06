/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:30 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:30 PM
 *
 */

package com.git.github.utils

import android.os.Handler
import java.util.concurrent.CopyOnWriteArrayList

class ApplicationLifeCycle private constructor()// Hidden constructor
{
    private val listeners = CopyOnWriteArrayList<LifeCycleListener>()
    var isForeground = false
        private set
    private var paused = true
    private val handler = Handler()
    private var runnable: Runnable? = null

    val isBackground: Boolean
        get() = !isForeground

    interface LifeCycleListener {

        fun onBecameForeground()

        fun onBecameBackground()

    }

    fun addListener(listener: LifeCycleListener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener)
        }
    }

    fun removeListener(listener: LifeCycleListener) {
        listeners.remove(listener)
    }

    /**
     * To be called from your base activity class in onResume
     */
    fun onActivityResumed() {
        paused = false
        val wasBackground = !isForeground
        isForeground = true

        handler.removeCallbacks(runnable)


        if (wasBackground) {
            for (listener in listeners) {
                try {
                    listener.onBecameForeground()
                } catch (exc: Exception) {
                }

            }
        } else {
            // Still in the foreground
        }
    }

    /**
     * To be called from your base activity class in onPause
     */
    fun onActivityPaused() {
        paused = true

        if (handler != null) {
            handler.removeCallbacks(runnable)

            handler.postDelayed({
                if (isForeground && paused) {
                    isForeground = false
                    for (l in listeners) {
                        try {
                            l.onBecameBackground()
                        } catch (exc: Exception) {

                        }

                    }
                } else {
                    // Still in the foreground
                }
            }, CHECK_DELAY)
        }
    }

    companion object {

        private val CHECK_DELAY: Long = 500

        private var instance: ApplicationLifeCycle? = null

        fun getInstance(): ApplicationLifeCycle {
            if (instance == null)
                instance = ApplicationLifeCycle()
            return instance as ApplicationLifeCycle
        }
    }

}