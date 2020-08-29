package com.example.podcastapp.views.viewholders

import android.view.View
import com.example.podcastapp.delegates.PodcastDelegate

class YourShowsViewHolder(itemview : View,mDelegate: PodcastDelegate) : BaseViewholder(itemview) {

    init {
        itemview.setOnClickListener {
            mDelegate.onItemClick()
        }
    }

}