package com.petter.mytvapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.Presenter
import com.petter.entity.Photo
import com.petter.mytvapp.databinding.CardDetailViewBinding
import com.petter.mytvapp.utils.loadImage

class DetailPresenter : Presenter() {

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardDetailViewBinding.inflate(inflater, parent, false)
        binding.root.tag = binding
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val photo = item as Photo
        val binding = viewHolder.view.tag as CardDetailViewBinding
        binding.detailImage.loadImage(photo.url)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

    }
}