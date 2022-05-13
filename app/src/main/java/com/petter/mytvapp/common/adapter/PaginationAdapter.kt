package com.petter.mytvapp.common.adapter

import android.content.Context
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.PresenterSelector
import com.petter.mytvapp.common.presenters.LoadingPresenter
import com.petter.mytvapp.components.LoadingCardView

abstract class PaginationAdapter(val presenter: Presenter, val context: Context) :
    ArrayObjectAdapter() {
    abstract fun addAllItems(items: List<Any>)
    abstract fun getAllItems(): List<Any>

    private var nextPage = 1
    private val loadingPresenter = LoadingPresenter()
    private var mLoadingIndicatorPosition = -1

    init {
        setPresenterSelector()
    }

    private fun setPresenterSelector() {
        presenterSelector = object : PresenterSelector() {
            override fun getPresenter(item: Any?): Presenter {
                return if (item is LoadingPresenter) loadingPresenter else presenter
            }
        }
    }

    fun shouldShowLoadingIndicator(): Boolean = mLoadingIndicatorPosition == -1

    private fun showLoading() {
        mLoadingIndicatorPosition = size()
        add(mLoadingIndicatorPosition, LoadingCardView(context))
        notifyItemRangeInserted(mLoadingIndicatorPosition, 1)
    }

    private fun hideLoading() {
        removeItems(mLoadingIndicatorPosition, 1)
        notifyItemRangeRemoved(mLoadingIndicatorPosition, 1)
        mLoadingIndicatorPosition = -1
    }

    fun handleLoading(isLoading: Boolean) {
        println("Here: is loading $isLoading")
        if (isLoading) showLoading()
        else hideLoading()
    }

    fun setNextPage(page: Int) {
        this.nextPage = page
    }
}