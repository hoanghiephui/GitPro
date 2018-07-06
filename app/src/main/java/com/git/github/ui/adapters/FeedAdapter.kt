/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 9:15 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 9:15 PM
 *
 */

package com.git.github.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.git.github.R
import com.git.github.ktextensions.inflate

class FeedAdapter: RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            FeedViewHolder(parent.inflate(R.layout.item_feed))

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
    }

    class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}