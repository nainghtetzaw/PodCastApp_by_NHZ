package com.example.podcastapp.mvp.presenters.implementations

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.mvp.presenters.interfaces.HomePresenter
import com.example.podcastapp.mvp.views.HomeView

class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    override fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner) {
        requestDataFromNetwork()
        getAllDataFromDataBase(context, lifecycleOwner)
    }

    override fun saveDownloadData(data: UpNextVO) {
        mModel.getDownloadedDataAndSaveToDatabase(data)
    }

    override fun onItemClick(id: String) {
        mView?.navigateToDetail(id)
    }

    override fun onDownloadClick(data: UpNextPodCastVO) {
        mView?.makeDownloadProgress(data)
    }

    private fun requestDataFromNetwork() {
        mModel.getRandomDataAndSaveToDatabase({}, {})
        mModel.getUpNextDataAndSaveToDatabase({}, {})
    }

    private fun getAllDataFromDataBase(context: Context, lifecycleOwner: LifecycleOwner) {
        mModel.getAllRandomPodCastData().observe(lifecycleOwner, Observer {
            if(it != null){
                mView?.showRandomPodCastData(it)
            }
        })
        mModel.getAllUpNextPodCastData().observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                mView?.showUpNextPodCastData(it)
            } else {
                Toast.makeText(context, "No data in database.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}