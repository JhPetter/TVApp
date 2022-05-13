package com.petter.mytvapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.lifecycle.lifecycleScope
import com.petter.entity.Photo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : DetailsSupportFragment() {
    private val photoDetailViewModel: PhotoDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            photoDetailViewModel.argsStateFlow.collect { args ->
                args?.let {
                    displayPhoto(it.item)
                }
            }
        }
    }

    private fun displayPhoto(photo: Photo) {
        val rowAdapter = ArrayObjectAdapter(DetailPresenter())
        rowAdapter.add(photo)
        val adapter = ArrayObjectAdapter(ListRowPresenter())
        adapter.add(ListRow(null, rowAdapter))
        this.adapter = adapter
    }

}