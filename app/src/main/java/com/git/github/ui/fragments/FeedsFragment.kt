/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 3:04 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 3:04 PM
 *
 */

package com.git.github.ui.fragments

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.git.github.R
import com.git.github.ui.BaseFragment
import com.git.github.ui.adapters.FeedAdapter
import kotlinx.android.synthetic.main.fragment_feeds.*

class FeedsFragment : BaseFragment() {
    override fun initLayout() =
            R.layout.fragment_feeds

    override fun initView(view: View) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseActivity())
            setHasFixedSize(true)
            adapter = FeedAdapter()
        }
    }

    override fun configureLogic() {
    }

    override fun configureViewModel() {
    }

    override fun onDestroyViews() {
    }
}