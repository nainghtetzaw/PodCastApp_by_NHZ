package com.example.podcastapp.mvp.views

import com.example.podcastapp.data.vos.UpNextVO

interface DownloadedShowsView : BaseView {
    fun navigateToDetail(id: String)
    fun showDownloadedData(data : List<UpNextVO>)
}