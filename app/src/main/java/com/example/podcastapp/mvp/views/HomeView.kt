package com.example.podcastapp.mvp.views

import com.example.podcastapp.data.vos.RandomPodCastVO
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO

interface HomeView : BaseView {
    fun navigateToDetail(id: String)
    fun showRandomPodCastData(data: RandomPodCastVO)
    fun showUpNextPodCastData(data: List<UpNextPodCastVO>)
    fun makeDownloadProgress(data : UpNextPodCastVO)
}