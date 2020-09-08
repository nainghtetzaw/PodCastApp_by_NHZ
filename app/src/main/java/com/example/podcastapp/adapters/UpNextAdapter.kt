package com.example.podcastapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.podcastapp.R
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.views.viewholders.UpNextViewHolder

class UpNextAdapter(delegate: PodcastDelegate) :
    com.example.share.BaseAdapter<UpNextViewHolder, UpNextPodCastVO>() {

    val mDelegate: PodcastDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpNextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_up_next, parent, false)
        return UpNextViewHolder(view, mDelegate)
    }
}