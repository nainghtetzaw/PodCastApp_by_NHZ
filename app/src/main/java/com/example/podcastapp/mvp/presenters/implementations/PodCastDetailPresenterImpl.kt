package com.example.podcastapp.mvp.presenters.implementations

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.podcastapp.mvp.presenters.interfaces.PodCastDetailPresenter
import com.example.podcastapp.mvp.views.PodCastDetailView

class PodCastDetailPresenterImpl : AbstractBasePresenter<PodCastDetailView>(),
    PodCastDetailPresenter {
    override fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner, id: String) {
//        requestDetailDataFromNetwork()
//        getPodCastDetailDataFromDataBase(id,lifecycleOwner)
//        requestData(id)
    }

//    private fun requestData(id: String){
//        mModel.getPodCastDetailData(id,{
//            mView?.showPodCastDetailData(it)
//        },{})
//    }

//    private fun requestDetailDataFromNetwork(){
//        mModel.getUpNextDataAndSaveToDatabase({},{})
//    }
//
//    private fun getPodCastDetailDataFromDataBase(id: String,lifecycleOwner: LifecycleOwner) {
//        mModel.getPodCastDetailData(id).observe(lifecycleOwner, Observer {
//            mView?.showPodCastDetailData(it)
//        })
//    }
}