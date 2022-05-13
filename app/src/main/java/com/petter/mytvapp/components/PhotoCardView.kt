package com.petter.mytvapp.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.leanback.widget.BaseCardView
import com.petter.mytvapp.databinding.CardPhotoViewBinding

class PhotoCardView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseCardView(context, attrs, defStyleAttr) {
    private val binding = CardPhotoViewBinding.inflate(LayoutInflater.from(context), this, true)

    var mainImageView: ImageView? = binding.photoImage

    fun setTitle(title: String) {
        binding.photoTitle.text = title
    }

    fun setSubTitle(subTitle: String) {
        binding.photoAuthor.text = subTitle
    }


}