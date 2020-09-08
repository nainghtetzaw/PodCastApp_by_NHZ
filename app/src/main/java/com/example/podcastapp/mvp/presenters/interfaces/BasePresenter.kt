package com.example.podcastapp.mvp.presenters.interfaces

import com.example.podcastapp.mvp.views.BaseView

interface BasePresenter <T : BaseView>{
    fun initPresenter(view : T)
}