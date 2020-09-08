package com.example.podcastapp.mvp.presenters.interfaces

import androidx.lifecycle.LifecycleOwner
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.delegates.DownloadDelegate
import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.mvp.views.DownloadedShowsView

interface DownloadedShowPresenter : BasePresenter<DownloadedShowsView>,DownloadDelegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}