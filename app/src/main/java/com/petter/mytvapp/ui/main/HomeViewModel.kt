package com.petter.mytvapp.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petter.entity.Photo
import com.petter.usecase.actions.FetchPhotosAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchPhotosAction: FetchPhotosAction) :
    ViewModel() {
    private val photoListMutableStateFlow: MutableStateFlow<List<Photo>> by lazy {
        MutableStateFlow(
            arrayListOf()
        )
    }
    val photoListStateFlow: StateFlow<List<Photo>> = photoListMutableStateFlow

    init {
        loadPhotos()
    }

    private fun loadPhotos() {
        viewModelScope.launch {
            val page = fetchPhotosAction.invoke(1)
            photoListMutableStateFlow.tryEmit(page.photos)
        }
    }
}