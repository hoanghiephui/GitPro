/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 8:13 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 8:13 PM
 *
 */

package com.git.github.api

import retrofit2.Retrofit

object GitHubFramework {
    private lateinit var retrofitInterface: FrameworkInterface

    val retrofitApiInstance: Retrofit
        get() = retrofitInterface.getRetrofitApiInstance()


    fun init(frameworkInterface: FrameworkInterface) {
        retrofitInterface = frameworkInterface
    }
}