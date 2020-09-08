package com.example.podcastapp.views.viewholders

import android.view.View
import com.example.podcastapp.data.vos.GenreVO
import com.example.podcastapp.views.viewholders.BaseViewHolders.BaseGenreViewHolder
import kotlinx.android.synthetic.main.item_category.view.*

class GenreViewHolder(itemview: View) : BaseGenreViewHolder(itemview) {
    override fun bindData(data: GenreVO) {
        mData = data
        itemView.tvPodCastCategoryType.text = data.name
    }
}