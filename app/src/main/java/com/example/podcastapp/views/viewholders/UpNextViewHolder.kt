package com.example.podcastapp.views.viewholders

import android.view.View
import android.view.animation.AnimationUtils
import com.bumptech.glide.Glide
import com.example.podcastapp.R
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.views.viewholders.BaseViewHolders.BaseUpNextViewHolder
import kotlinx.android.synthetic.main.item_up_next.view.*

class UpNextViewHolder(itemview: View, delegate: PodcastDelegate) : BaseUpNextViewHolder(itemview) {

    init {
        itemview.imgPodCastPoster.setOnClickListener {
            mData?.let {
                delegate.onItemClick(it.id)
            }
        }
        itemview.imgDownload.setOnClickListener {
            mData?.let {
                delegate.onDownloadClick(it)
            }
        }
    }

    override fun bindData(data: UpNextVO) {
        mData = data
        Glide.with(itemView.context)
            .load(data.image)
            .into(itemView.imgPodCastPoster)
        itemView.tvPodcastName.text = data.title
    }
}