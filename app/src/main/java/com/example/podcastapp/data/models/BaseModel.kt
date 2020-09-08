package com.example.podcastapp.data.models

import android.content.Context
import com.example.podcastapp.network.PodcastApi
import com.example.podcastapp.persistence.database.PodCastDatabase
import com.example.podcastapp.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mPodCastApi: PodcastApi
    protected lateinit var mPodCastDb: PodCastDatabase

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mPodCastApi = mRetrofit.create(PodcastApi::class.java)
    }

    fun initDatabase(context: Context) {
        mPodCastDb = PodCastDatabase.getDbInstance(context)
    }

}