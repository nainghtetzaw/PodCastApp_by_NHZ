package com.example.podcastapp.mvp.presenters.interfaces

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.mvp.views.HomeView

interface HomePresenter : PodcastDelegate, BasePresenter<HomeView> {
    fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner)
//    fun saveDownloadData(data : UpNextVO)
}