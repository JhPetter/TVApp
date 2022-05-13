package com.petter.mytvapp.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.leanback.widget.BaseCardView
import com.petter.mytvapp.databinding.CardLoadingViewBinding

class LoadingCardView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BaseCardView(context, attrs, defStyleAttr) {

    private val binding = CardLoadingViewBinding.inflate(LayoutInflater.from(context), this, true)

    fun isLoading(isLoading: Boolean) {
        binding.progressLoading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}