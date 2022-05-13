package com.petter.mytvapp.common.presenters

import android.view.ViewGroup
import androidx.leanback.widget.VerticalGridPresenter

class MyVerticalGridPresenter : VerticalGridPresenter() {
    override fun initializeGridViewHolder(vh: ViewHolder) {
        super.initializeGridViewHolder(vh)
        val gridView = vh.gridView
        val parameters = gridView.layoutParams
        parameters.width = ViewGroup.LayoutParams.MATCH_PARENT
        gridView.layoutParams = parameters
    }
}