package com.example.podcastapp

import android.app.Application
import com.example.podcastapp.data.models.PodCastModelImpl

class PodCastApp : Application() {

    override fun onCreate() {
        super.onCreate()
//        PodCastModelImpl.initDatabase(applicationContext)
//        getPodCastDataOneTime()
    }

//    private fun getPodCastDataOneTime() {
//        val getEventWorkRequest = OneTimeWorkRequest
//            .Builder(PodCastWorker::class.java)
//            .build()
//        WorkManager.getInstance(applicationContext)
//            .enqueue(getEventWorkRequest)
//    }

}