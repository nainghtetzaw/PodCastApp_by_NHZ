package com.example.podcastapp.mvp.presenters.interfaces

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.podcastapp.mvp.views.PodCastDetailView

interface PodCastDetailPresenter : BasePresenter<PodCastDetailView> {
    fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner, id: String)
}