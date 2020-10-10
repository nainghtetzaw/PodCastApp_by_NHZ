package com.example.podcastapp.mvp.presenters.implementations

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.podcastapp.mvp.presenters.interfaces.DownloadedShowPresenter
import com.example.podcastapp.mvp.views.DownloadedShowsView

class DownloadedShowPresenterImpl : DownloadedShowPresenter,
    AbstractBasePresenter<DownloadedShowsView>() {
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
//        getDownloadDataFromDatabase(lifecycleOwner)
//        requestData()
    }

    override fun onItemClick(id: String,name : String,description : String,audio: String,audiolength : Int,image : String) {
        mView?.navigateToDetail(id,name,description,audio,audiolength,image)
    }

//    private fun requestData(){
//        mModel.getDownloadPoeCastData({
//            mView?.showDownloadedData(it)
//        },{})
//    }

//    private fun getDownloadDataFromDatabase(lifecycleOwner: LifecycleOwner){
//        mModel.getAllDownloadPodCastData().observe(lifecycleOwner, Observer {
//            mView?.showDownloadedData(it)
//        })
//    }
}