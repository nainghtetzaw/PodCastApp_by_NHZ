package com.example.podcastapp.mvp.presenters

import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.mvp.views.HomeView

interface HomePresenter : PodcastDelegate,BasePresenter<HomeView>{
}