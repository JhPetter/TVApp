package com.petter.mytvapp.ui.search

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.leanback.app.SearchSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.petter.entity.Photo
import com.petter.mytvapp.R
import com.petter.mytvapp.ui.main.HomeFragmentDirections
import com.petter.mytvapp.ui.main.PhotoPresenter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment : SearchSupportFragment(), SearchSupportFragment.SearchResultProvider {

    private val searchViewModel: SearchViewModel by viewModels()

    private lateinit var mAdapter: ArrayObjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpFragment()
        setSearchResultProvider(this)
        observerViewModel()
        configActions()
    }

    private fun setUpFragment() {
        mAdapter = ArrayObjectAdapter(ListRowPresenter())
    }

    private fun observerViewModel() {
        lifecycleScope.launch {
            searchViewModel.photoListStateFlow.collect {
                showPhotos(it)
            }
        }
    }

    private fun configActions() {
        setOnItemViewClickedListener { _, item, _, _ ->
            if (item is Photo) {
                val position = searchViewModel.photoListStateFlow.value.indexOf(item)
                val photos: List<Photo> = searchViewModel.photoListStateFlow.value
                openDetail(position, photos)
            }
        }
    }

    private fun openDetail(position: Int, photos: List<Photo>) {
        val action = SearchFragmentDirections.navSearchOpenDetail(position, photos.toTypedArray())

        findNavController().navigate(
            action,
            NavOptions.Builder().setPopUpTo(R.id.navDetail, true).build()
        )
    }


    private fun showPhotos(photos: List<Photo>) {
        val header = HeaderItem("Search for ${searchViewModel.mQuery}")
        mAdapter.clear()
        val rowAdapter = ArrayObjectAdapter(PhotoPresenter())
        rowAdapter.addAll(0, photos)
        val row = ListRow(header, rowAdapter)
        mAdapter.add(row)
    }

    override fun getResultsAdapter(): ObjectAdapter = mAdapter

    override fun onQueryTextChange(newQuery: String?): Boolean {
        searchViewModel.search(newQuery ?: "")
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        searchViewModel.search(query ?: "")
        return true
    }

}