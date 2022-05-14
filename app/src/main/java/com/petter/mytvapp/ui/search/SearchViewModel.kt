package com.petter.mytvapp.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petter.entity.Photo
import com.petter.usecase.actions.SearchPhotosAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val searchPhotosAction: SearchPhotosAction) :
    ViewModel() {
    private val photoListMutableStateFlow: MutableStateFlow<List<Photo>> by lazy {
        MutableStateFlow(
            arrayListOf()
        )
    }
    val photoListStateFlow: StateFlow<List<Photo>> = photoListMutableStateFlow

    var mQuery = ""

    fun search(query: String) {
        viewModelScope.launch {
            if (query.isNotEmpty() && mQuery != query) {
                mQuery = query
                val page = searchPhotosAction.invoke(query, 1)
                photoListMutableStateFlow.tryEmit(page.photos)
            }
        }
    }
}