/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 4:00 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 4:00 PM
 *
 */

package com.git.github.dl.module

import android.util.Log
import com.git.github.BuildConfig
import com.git.github.api.EnvironmentSettings
import com.git.github.utils.TLSSocketFactory
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
                .connectionSpecs(listOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT))
                .connectTimeout(API_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(API_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(API_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .pingInterval(PING_INTERVAL.toLong(), TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                // Add logging for debugging purposes
                .addInterceptor(LoggingInterceptor.Builder()
                        .loggable(BuildConfig.DEBUG)
                        .tag("LoggingI")
                        .setLevel(Level.BASIC)
                        .log(Platform.INFO)
                        .request("Request")
                        .response("Response").build())

        /*
          Enable TLS specific version V.1.2
          Issue Details : https://github.com/square/okhttp/issues/1934
         */
        try {
            val tlsSocketFactory = TLSSocketFactory()
            builder.sslSocketFactory(tlsSocketFactory, tlsSocketFactory.systemDefaultTrustManager())
        } catch (e: KeyManagementException) {
            Log.e(TAG, "Failed to create Socket connection ", e)
        } catch (e: NoSuchAlgorithmException) {
            Log.e(TAG, "Failed to create Socket connection ", e)
        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideJacksonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    @Named("api")
    fun provideRetrofitApiInstance(okHttpClient: OkHttpClient,
                                   converterFactory: GsonConverterFactory,
                                   rxJavaCallFactory: RxJava2CallAdapterFactory,
                                   environmentSettings: EnvironmentSettings): Retrofit {
        return Retrofit.Builder()
                .baseUrl(environmentSettings.apiUrl)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(rxJavaCallFactory)
                .build()
    }


    companion object {
        private val TAG = ApplicationModule::class.java.simpleName
        private val API_TIMEOUT = 60
        private val PING_INTERVAL = 10
    }
}