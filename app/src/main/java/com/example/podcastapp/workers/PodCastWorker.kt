package com.example.podcastapp.workers

import android.content.Context
import androidx.work.WorkerParameters

class PodCastWorker(context: Context, workerParams: WorkerParameters) :
    BaseWorker(context, workerParams) {

    override fun doWork(): Result {
        val result = Result.failure()
        return result
    }
}