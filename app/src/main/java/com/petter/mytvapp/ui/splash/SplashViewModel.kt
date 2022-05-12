package com.petter.mytvapp.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val openHomeMutableStateFlow: MutableStateFlow<Boolean> by lazy { MutableStateFlow(false) }
    val openHomeStateFlow: StateFlow<Boolean> = openHomeMutableStateFlow

    init {
        viewModelScope.launch {
            delay(2000)
            openHomeMutableStateFlow.tryEmit(true)
        }
    }
}