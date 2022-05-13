package com.petter.mytvapp.common.presenters

import android.view.ViewGroup
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.Presenter
import com.petter.mytvapp.R
import com.petter.mytvapp.components.LoadingCardView

class LoadingPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val imageCardView = LoadingCardView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            cardType = BaseCardView.CARD_TYPE_MAIN_ONLY
            val posterWidth = parent.resources.getDimension(R.dimen.poster_width).toInt()
            val posterHeight = parent.resources.getDimension(R.dimen.poster_height).toInt()
            layoutParams = BaseCardView.LayoutParams(posterWidth, posterHeight)
        }
        return ViewHolder(imageCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        with(viewHolder.view as LoadingCardView){
            this.isLoading(true)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as LoadingCardView){
            this.isLoading(false)
        }
    }
}