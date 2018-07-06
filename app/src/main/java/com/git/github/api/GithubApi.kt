/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 4:10 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 4:10 PM
 *
 */

package com.git.github.api

class GithubApi {
    /**
     * Lazily evaluates an instance of [GitHubEndpoint].
     */
    private val endpoints: GitHubEndpoint by lazy {
        GitHubFramework.retrofitApiInstance
                .create(GitHubEndpoint::class.java)
    }
}