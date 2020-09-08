package com.example.podcastapp.mvp.presenters.implementations

import androidx.lifecycle.ViewModel
import com.example.podcastapp.data.models.PodCastModel
import com.example.podcastapp.data.models.PodCastModelImpl
import com.example.podcastapp.mvp.presenters.interfaces.BasePresenter
import com.example.podcastapp.mvp.views.BaseView

abstract class AbstractBasePresenter<V : BaseView> : BasePresenter<V>,ViewModel() {

    var mModel: PodCastModel = PodCastModelImpl
    var mView: V? = null

    override fun initPresenter(view: V) {
        mView = view
    }
}