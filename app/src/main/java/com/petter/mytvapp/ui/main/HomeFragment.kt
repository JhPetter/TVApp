package com.petter.mytvapp.ui.main

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.lifecycle.lifecycleScope
import com.petter.entity.Photo
import com.petter.mytvapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BrowseSupportFragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        headersState = HEADERS_DISABLED
        searchAffordanceColor = ContextCompat.getColor(this.requireContext(), R.color.colorPrimary)

        configData()
        observeViewModel()
    }

    private fun configData() {
        title = getString(R.string.photo_search)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            homeViewModel.photoListStateFlow.collect {
                println("Here: size of photos ${it.size}")
                showData(it)
            }
        }
    }

    private fun showData(photos: List<Photo>) {
        val adapter = ArrayObjectAdapter(ListRowPresenter())
        val headerItem = HeaderItem(1L, "Trending Now On Flickr")
        val rowAdapter = ArrayObjectAdapter(PhotoPresenter())
        rowAdapter.addAll(0, photos)
        adapter.add(ListRow(headerItem, rowAdapter))
        this.adapter = adapter
    }
}