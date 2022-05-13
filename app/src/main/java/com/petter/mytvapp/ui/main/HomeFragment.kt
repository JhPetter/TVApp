package com.petter.mytvapp.ui.main

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.petter.entity.Photo
import com.petter.mytvapp.R
import com.petter.mytvapp.common.presenters.MyVerticalGridPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : VerticalGridSupportFragment() {
    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var mAdapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchAffordanceColor = ContextCompat.getColor(this.requireContext(), R.color.colorPrimary)
        setUpFragment()
        configData()
        observeViewModel()
        configActions()
    }

    private fun setUpFragment() {
        mAdapter = PhotoAdapter(this.requireContext())
        val verticalGridPresenter = MyVerticalGridPresenter()
            .apply {
                numberOfColumns = 4
                shadowEnabled = false
            }
        verticalGridPresenter.numberOfColumns = 3

        gridPresenter = verticalGridPresenter
        this.adapter = mAdapter
    }

    private fun configData() {
        title = getString(R.string.photo_search)
    }

    private fun configActions() {
        setOnSearchClickedListener {
            println("Here: setOnSearchClickedListener")
        }
        setOnItemViewClickedListener { itemViewHolder, item, rowViewHolder, row ->
            println("Here: setOnItemViewClickedListener")
            if (item is Photo) {
                val photos: List<Photo> = mAdapter.getAllItems() as List<Photo>
                val action = HomeFragmentDirections.navHomeOpenDetail(0, photos.toTypedArray())

                findNavController().navigate(
                    action,
                    NavOptions.Builder().setPopUpTo(R.id.navDetail, true).build()
                )
            }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            homeViewModel.photoListStateFlow.collect {
                println("Here: size of photos ${it.size}")
                mAdapter.addAllItems(it)
            }
        }

        lifecycleScope.launch {
            homeViewModel.photoLoadingStateFlow.collect {
                mAdapter.handleLoading(it)
            }
        }
    }
}