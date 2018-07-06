/*
 * *
 *  * Created by Hoang Hiep on 6/30/18 9:33 PM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 6/30/18 9:33 PM
 *
 */

package com.git.github.ui.adapters.viewholder

import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import com.git.github.R
import com.git.github.ui.adapters.base.BaseViewHolder

class ProgressBarViewHolder private constructor(@NonNull itemView: View) : BaseViewHolder<Any>(itemView) {

    override fun bind(t: Any) {}

    companion object {
        fun newInstance(viewGroup: ViewGroup): ProgressBarViewHolder {
            return ProgressBarViewHolder(getView(viewGroup, R.layout.progress_layout))
        }
    }
}