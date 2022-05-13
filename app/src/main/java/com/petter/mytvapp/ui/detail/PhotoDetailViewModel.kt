package com.petter.mytvapp.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.petter.entity.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val photosMutableStateFlow: MutableStateFlow<List<Photo>> by lazy {
        MutableStateFlow(arrayListOf())
    }
    val photosStateFlow: StateFlow<List<Photo>> = photosMutableStateFlow

    private val positionFocusMutableStateFlow: MutableStateFlow<Int> by lazy {
        MutableStateFlow(0)
    }

    val positionFocusStateFlow: StateFlow<Int> = positionFocusMutableStateFlow

    private var position = 0
    private var photos: List<Photo> = arrayListOf()

    init {
        val args = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle)
        displayPhotos(args.photos)
        position = args.currentPosition
        positionFocusMutableStateFlow.tryEmit(position)
    }

    private fun displayPhotos(photos: Array<Photo>) {
        this.photos = photos.toList()
        photosMutableStateFlow.tryEmit(this.photos)
    }

    fun focusNextPhoto() {
        if (position == photos.size - 1)
            position = 0
        else
            position += 1
        positionFocusMutableStateFlow.tryEmit(position)
    }

    fun focusPreviewPhoto() {
        if (position == 0)
            position = photos.size - 1
        else
            position -= 1

        positionFocusMutableStateFlow.tryEmit(position)
    }
}