package com.petter.mytvapp.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val argsMutableStateFlow: MutableStateFlow<DetailFragmentArgs?> by lazy {
        MutableStateFlow(null)
    }
    val argsStateFlow: StateFlow<DetailFragmentArgs?> = argsMutableStateFlow

    init {
        val args = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle)
        argsMutableStateFlow.tryEmit(args)
    }
}