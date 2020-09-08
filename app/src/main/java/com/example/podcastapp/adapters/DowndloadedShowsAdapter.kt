package com.example.podcastapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.podcastapp.R
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.delegates.DownloadDelegate
import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.views.viewholders.DownloadedShowsViewHolder
import com.example.share.BaseAdapter

class DowndloadedShowsAdapter(delegate: DownloadDelegate) :
    BaseAdapter<DownloadedShowsViewHolder,UpNextVO>() {

    private val mDelegate: DownloadDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadedShowsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_your_shows, parent, false)
        return DownloadedShowsViewHolder(view, mDelegate)
    }
}