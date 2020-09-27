package com.example.podcastapp.mvp.presenters.implementations

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.podcastapp.mvp.presenters.interfaces.SearchPresenter
import com.example.podcastapp.mvp.views.SearchView

class SearchPresenterImpl : SearchPresenter, AbstractBasePresenter<SearchView>() {

    override fun onUiReady(context: Context, lifecycleOwner: LifecycleOwner) {
        requestData()
//        requestDataFromNetwork()
//        getDataFromDataBase(context, lifecycleOwner)
    }

    private fun requestData(){
        mModel.getGenrePodCastData({
            mView?.showGenreData(it)
        },{})
    }

//    private fun requestDataFromNetwork() {
//        mModel.getGenreDataAndSaveToDatabase({}, {})
//    }
//
//    private fun getDataFromDataBase(context: Context, lifecycleOwner: LifecycleOwner) {
//        mModel.getAllGenreData().observe(lifecycleOwner, Observer {
//            if (it.isNotEmpty()) {
//                mView?.showGenreData(it)
//            } else {
//                Toast.makeText(context, "No Data in Genre Database", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
}