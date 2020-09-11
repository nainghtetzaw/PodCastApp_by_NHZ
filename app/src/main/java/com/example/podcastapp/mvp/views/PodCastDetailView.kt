package com.example.podcastapp.mvp.views

import com.example.podcastapp.data.vos.UpNextVO

interface PodCastDetailView : BaseView {
    fun showPodCastDetailData(data: UpNextVO)
}