package com.example.podcastapp.mvp.presenters

import com.example.podcastapp.mvp.views.YourShowView

class YourShowPresenterImpl : YourShowPresenter,AbstractBasePresenter<YourShowView>() {
    override fun onItemClick() {
        mView?.navigateToDetail()
    }
}