/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 8:12 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 8:12 PM
 *
 */

package com.git.github.api

import retrofit2.Retrofit

interface FrameworkInterface {
    /**
     * Provides an instance of Retrofit with it's base URL
     */
    abstract fun getRetrofitApiInstance(): Retrofit
}