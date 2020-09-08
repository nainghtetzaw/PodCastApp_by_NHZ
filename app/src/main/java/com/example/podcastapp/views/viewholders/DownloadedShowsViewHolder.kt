package com.example.podcastapp.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.delegates.DownloadDelegate
import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.utils.PARAM_DETAIL_PODCAST_ID
import com.example.podcastapp.views.viewholders.BaseViewHolders.BaseDownLoadedShowsViewHolder
import kotlinx.android.synthetic.main.item_your_shows.view.*

class DownloadedShowsViewHolder(itemview: View,mDelegate: DownloadDelegate) :
    BaseDownLoadedShowsViewHolder(itemview) {

    init {
        itemview.imgYourShowPoster.setOnClickListener {
            mData?.let {
                mDelegate.onItemClick(PARAM_DETAIL_PODCAST_ID)
            }
        }
    }

    override fun bindData(data: UpNextVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.imgYourShowPoster)
        itemView.tvYourShowName.text = data.title
    }

}