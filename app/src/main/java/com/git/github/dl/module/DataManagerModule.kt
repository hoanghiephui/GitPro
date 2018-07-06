/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 4:01 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 4:01 PM
 *
 */

package com.git.github.dl.module

import com.git.github.api.GithubApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataManagerModule {
    @Provides
    @Singleton
    fun provideVietnamAirlineApiFactory(): GithubApi {
        return GithubApi()
    }
}