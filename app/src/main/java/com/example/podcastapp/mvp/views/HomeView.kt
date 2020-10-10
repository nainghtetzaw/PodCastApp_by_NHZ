package com.example.podcastapp.mvp.views

import com.example.podcastapp.data.vos.RandomPodCastVO
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO

interface HomeView : BaseView {
    fun navigateToDetail(id : String,name : String,description : String,audio: String,audiolength : Int,image : String)
    fun showRandomPodCastData(data: UpNextVO)
    fun showUpNextPodCastData(data: List<UpNextVO>)
    fun makeDownloadProgress(data : UpNextVO)
}