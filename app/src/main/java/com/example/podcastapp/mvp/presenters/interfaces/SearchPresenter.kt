package com.example.podcastapp.mvp.presenters.interfaces

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.podcastapp.mvp.views.SearchView

interface SearchPresenter : BasePresenter<SearchView> {
    fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner)
}