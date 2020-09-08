package com.example.podcastapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.podcastapp.R
import com.example.podcastapp.data.vos.GenreVO
import com.example.podcastapp.views.viewholders.GenreViewHolder

class GenreAdapter : com.example.share.BaseAdapter<GenreViewHolder, GenreVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return GenreViewHolder(view)
    }
}