package com.example.podcastapp.mvp.presenters.implementations

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.mvp.presenters.interfaces.HomePresenter
import com.example.podcastapp.mvp.views.HomeView
import com.google.android.material.snackbar.Snackbar

class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    override fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner) {
        requestData()
//        requestDataFromNetwork()
//        getAllDataFromDataBase(context, lifecycleOwner)
    }

//    override fun saveDownloadData(data: UpNextVO) {
////        mModel.getDownloadedDataAndSaveToDatabase(data)
//        mModel.downloadPodCastData(data)
//    }

    override fun onItemClick(
        id: String,
        name: String,
        description: String,
        audio: String,
        audiolength: Int,
        image: String
    ) {
        mView?.navigateToDetail(id,name,description,audio,audiolength,image)
    }


    override fun onDownloadClick(data: UpNextVO) {
        mView?.makeDownloadProgress(data)
    }

    private fun requestData(){
//        mModel.getRandomPodCastData({
//            mView?.showRandomPodCastData(it)
//        },{})
        mModel.getUpNextPodCastData({
            val randomNum = (it.indices).random()
            mView?.showRandomPodCastData(it[randomNum])
            mView?.showUpNextPodCastData(it)
        },{})
    }

//    private fun requestDataFromNetwork() {
//        mModel.getRandomDataAndSaveToDatabase({}, {})
//        mModel.getUpNextDataAndSaveToDatabase({}, {})
//    }

//    private fun getAllDataFromDataBase(context: Context, lifecycleOwner: LifecycleOwner) {
//        mModel.getAllRandomPodCastData().observe(lifecycleOwner, Observer {
//            if(it != null){
//                mView?.showRandomPodCastData(it)
//            }
//        })
//        mModel.getAllUpNextPodCastData().observe(lifecycleOwner, Observer {
//            if (it.isNotEmpty()) {
//                mView?.showUpNextPodCastData(it)
//            } else {
//                Toast.makeText(context, "No data in database.", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}