package com.example.podcastapp.mvp.presenters.implementations

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.podcastapp.mvp.presenters.interfaces.PodCastDetailPresenter
import com.example.podcastapp.mvp.views.PodCastDetailView

class PodCastDetailPresenterImpl : AbstractBasePresenter<PodCastDetailView>(),
    PodCastDetailPresenter {
    override fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner, id: String) {
        requestPodCastDetailDataFromNetwork(id)
        getPodCastDetailDataFromDataBase(lifecycleOwner)
    }

    private fun requestPodCastDetailDataFromNetwork(id: String) {
        mModel.getPodCastDetailDataAndSaveToDatabase(id, {}, {})
    }

    private fun getPodCastDetailDataFromDataBase(lifecycleOwner: LifecycleOwner) {
        mModel.getAllPodCastDetailData().observe(lifecycleOwner, Observer {
            if(it != null){
                mView?.showPodCastDetailData(it)
            }
        })
    }
}