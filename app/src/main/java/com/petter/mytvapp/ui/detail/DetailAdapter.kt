package com.petter.mytvapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.petter.entity.Photo
import com.petter.mytvapp.databinding.CardDetailViewBinding
import com.petter.mytvapp.utils.loadImage

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {
    var photos: List<Photo> = arrayListOf()
        set(value) {
            field = value
            notifyItemChanged(0)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val itemView =
            CardDetailViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(photos[position])
    }

    override fun getItemCount(): Int = photos.size


    class DetailViewHolder(private val binding: CardDetailViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: Photo) {
            binding.detailImage.loadImage(photo.url)
        }
    }
}