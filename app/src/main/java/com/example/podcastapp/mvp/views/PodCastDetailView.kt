package com.example.podcastapp.mvp.views

import com.example.podcastapp.data.vos.PodCastDetailVO

interface PodCastDetailView : BaseView {
    fun showPodCastDetailData(data: PodCastDetailVO)
}