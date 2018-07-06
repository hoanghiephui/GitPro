/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:42 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/13/18 6:05 PM
 *
 */

package com.git.github.ktextensions

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/**
 * @author hoanghiep
 */

/**
 * @use “I’m a long toast”.shortToast(context)
 */
fun Any.shortToast(ctx: Context) = Toast.makeText(ctx, this.toString(), Toast.LENGTH_SHORT).show()

/**
 * @use “I’m a long toast”.longToast(context)
 */
fun Any.longToast(ctx: Context) = Toast.makeText(ctx, this.toString(), Toast.LENGTH_LONG).show()

/**
 * @use “I’m a long toast”.showLongSnack(view)
 */
fun Any.showLongSnack(view: View) = Snackbar.make(view, this.toString(), Snackbar.LENGTH_LONG).show()

/**
 * @use “I’m a long toast”.showShortSnack(view)
 */
fun Any.showShortSnack(view: View) = Snackbar.make(view, this.toString(), Snackbar.LENGTH_SHORT).show()