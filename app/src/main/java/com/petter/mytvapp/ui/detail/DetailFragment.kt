package com.petter.mytvapp.ui.detail

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.petter.entity.Photo
import com.petter.mytvapp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val photoDetailViewModel: PhotoDetailViewModel by viewModels()
    private val adapter = DetailAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.detailList.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        validateKeys()
    }

    private fun validateKeys() {
        binding.detailList.setOnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT && event.action == KeyEvent.ACTION_UP) {
                photoDetailViewModel.focusPreviewPhoto()
            } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT && event.action == KeyEvent.ACTION_UP)
                photoDetailViewModel.focusNextPhoto()
            else if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP)
                navigateBack()
            true
        }
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }


    private fun observeViewModel() {
        lifecycleScope.launch {
            photoDetailViewModel.photosStateFlow.collect { photos ->
                displayPhoto(photos)
            }
        }
        lifecycleScope.launch {
            photoDetailViewModel.positionFocusStateFlow.collect {
                focusPhoto(it)
            }
        }
    }

    private fun displayPhoto(photos: List<Photo>) {
        adapter.photos = photos.toList()
    }

    private fun focusPhoto(position: Int) {
        binding.detailList.scrollToPosition(position)
    }
}