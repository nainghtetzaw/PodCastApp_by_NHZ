package com.example.podcastapp.mvp.presenters

import com.example.podcastapp.mvp.views.HomeView

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {
    override fun onItemClick() {
        mView?.navigateToDetail()
    }
}