package com.petter.mytvapp.ui.main

import android.view.ViewGroup
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.Presenter
import com.petter.entity.Photo
import com.petter.mytvapp.R
import com.petter.mytvapp.components.PhotoCardView
import com.petter.mytvapp.utils.loadImage

class PhotoPresenter : Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val imageCardView = PhotoCardView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            cardType = BaseCardView.CARD_TYPE_MAIN_ONLY
            val posterWidth = parent.resources.getDimension(R.dimen.poster_width).toInt()
            val posterHeight = parent.resources.getDimension(R.dimen.poster_height).toInt()
            layoutParams = BaseCardView.LayoutParams(posterWidth, posterHeight)
        }
        return ViewHolder(imageCardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val photo = item as Photo
        with(viewHolder.view as PhotoCardView) {
            val posterWidth = resources.getDimension(R.dimen.poster_width).toInt()
            val posterHeight = resources.getDimension(R.dimen.poster_height).toInt()

            mainImageView?.loadImage(
                url = photo.url,
                posterHeight = posterHeight,
                posterWidth = posterWidth
            )
            setTitle(photo.title)
            setSubTitle("${photo.authorName} / ${photo.publishDate}")
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as PhotoCardView) {
            mainImageView = null
        }
    }
}