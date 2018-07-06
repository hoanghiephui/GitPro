/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:42 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 5/11/18 6:34 PM
 *
 */

package com.git.github.ktextensions

import android.text.TextUtils
import java.util.regex.Pattern

val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"

// used for validate if the current String is an email
fun String.isValidEmail(): Boolean {
    val pattern = Pattern.compile(EMAIL_PATTERN)
    return pattern.matcher(this).matches()
}

fun String.isNull(): Boolean {
    return TextUtils.isEmpty(this)
}