package com.example.podcastapp.mvp.views

import com.example.podcastapp.data.vos.UpNextVO

interface DownloadedShowsView : BaseView {
    fun navigateToDetail(id: String,name : String,description : String,audio: String,audiolength : Int,image : String)
    fun showDownloadedData(data : List<UpNextVO>)
}