/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:37 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/29/18 11:18 AM
 *
 */

package com.git.github.ktextensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.git.github.R
import java.util.*


inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
    val fragmentTransaction = beginTransaction()
    fragmentTransaction.func()
    fragmentTransaction.commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int, tag: String?) {
    supportFragmentManager.inTransaction {
        tag?.let {
            addToBackStack(it)
        }
        add(frameId, fragment)
    }
}


fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int, tag: String?) {
    supportFragmentManager.inTransaction {
        tag?.let {
            addToBackStack(it)
        }
        replace(frameId, fragment)
    }
}

fun ClosedRange<Int>.random() =
        Random().nextInt(endInclusive - start) + start