/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:43 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 5/21/18 12:38 PM
 *
 */

@file:JvmName("ViewExtensions")

package com.git.github.ktextensions

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce

/**
 * Sets the visibility of a [View] to [View.VISIBLE]
 */
fun View?.visible() {
    if (this != null) visibility = View.VISIBLE
}

/**
 * Sets the visibility of a [View] to [View.INVISIBLE]
 */
fun View?.invisible() {
    if (this != null) visibility = View.INVISIBLE
}

/**
 * Sets the visibility of a [View] to [View.GONE]
 */
fun View?.gone() {
    if (this != null) visibility = View.GONE
}

/**
 * Allows a [ViewGroup] to inflate itself without all of the unneeded ceremony of getting a
 * [LayoutInflater] and always passing the [ViewGroup] + false. True can optionally be passed if
 * needed.
 *
 * @param layoutId The layout ID as an [Int]
 * @return The inflated [View]
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

/**
 * Returns the current [String] entered into an [EditText]. Non-null, ie can return an empty String.
 */
fun EditText?.getTextString(): String {
    return this?.text.toString()
}

fun TextView?.getTextString(): String {
    return this?.text.toString()
}

/**
 * This disables the soft keyboard as an input for a given [EditText]. The method
 * [EditText.setShowSoftInputOnFocus] is officially only available on >API21, but is actually hidden
 * from >API16. Here, we attempt to set that field to false, and catch any exception that might be
 * thrown if the Android implementation doesn't include it for some reason.
 */
@SuppressLint("NewApi")
fun EditText.disableSoftKeyboard() {
    try {
        showSoftInputOnFocus = false
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**
 * Returns a physics-based [SpringAnimation] for a given [View].
 *
 * @param property The [DynamicAnimation.ViewProperty] you wish to animate, such as rotation,
 * X or Y position etc.
 * @param finalPosition The end position for the [View] after animation complete
 * @param stiffness The stiffness of the animation, see [SpringForce]
 * @param dampingRatio The damping ratio of the animation, see [SpringForce]
 */
fun View.createSpringAnimation(
        property: DynamicAnimation.ViewProperty,
        finalPosition: Float,
        stiffness: Float,
        dampingRatio: Float
) = SpringAnimation(this, property).apply {
    spring = SpringForce(finalPosition).apply {
        this.stiffness = stiffness
        this.dampingRatio = dampingRatio
    }
}

fun View.OnClickListener.listenClickViews(vararg views: View) {
    views.forEach { it.setOnClickListener(this) }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(findViewById<View>(android.R.id.content).getWindowToken(), 0)
}

fun View.OnClickListener.clickHideKeyboard(vararg views: View) {
    views.forEach {
        it.setOnClickListener {
            it.hideKeyboard()
        }
    }
}
