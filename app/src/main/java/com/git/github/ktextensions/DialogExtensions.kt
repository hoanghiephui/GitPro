/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:39 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 3/28/18 8:44 AM
 *
 */

package com.git.github.ktextensions

import android.app.Dialog
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog

/**
 * Created by hoanghiep on 3/19/18.
 */

fun <T : Dialog> T.applyOnShow(action: T.() -> Unit) {
    setOnShowListener { dialog ->
        @Suppress("UNCHECKED_CAST")
        action(dialog as T)
    }
}

fun AlertDialog.Builder.positive(@StringRes textId: Int, action: (dialog: AlertDialog) -> Unit) {
    setPositiveButton(textId) { dialog, _ ->
        action(dialog as AlertDialog)
    }
}

fun AlertDialog.Builder.negative(@StringRes textId: Int, action: (dialog: AlertDialog) -> Unit) {
    setNegativeButton(textId) { dialog, _ ->
        action(dialog as AlertDialog)
    }
}

fun <T : Dialog> T.onShow(action: (dialog: T) -> Unit) {
    setOnShowListener { dialog ->
        @Suppress("UNCHECKED_CAST")
        action(dialog as T)
    }
}