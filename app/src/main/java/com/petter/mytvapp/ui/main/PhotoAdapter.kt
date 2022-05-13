package com.petter.mytvapp.ui.main

import android.content.Context
import com.petter.entity.Photo
import com.petter.mytvapp.common.adapter.PaginationAdapter

class PhotoAdapter(mContext: Context) : PaginationAdapter(PhotoPresenter(), mContext) {
    override fun addAllItems(items: List<Any>) {
        val currentPhotos = getAllItems()
        val photos = arrayListOf<Photo>()
        for (item in items) {
            if (item is Photo && !currentPhotos.contains(item)) photos.add(item)
        }
        if (photos.size > 0) {
            addAll(size(), photos)
        } else
            setNextPage(0)
    }

    override fun getAllItems(): List<Any> {
        val items: List<Any> = unmodifiableList()
        val photos = arrayListOf<Photo>()
        for (item in items) {
            if (item is Photo) photos.add(item)
        }
        return photos
    }
}