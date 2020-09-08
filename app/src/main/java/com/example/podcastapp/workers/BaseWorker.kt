package com.example.podcastapp.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.podcastapp.data.models.PodCastModel
import com.example.podcastapp.data.models.PodCastModelImpl

abstract class BaseWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    val mModel: PodCastModel = PodCastModelImpl
}