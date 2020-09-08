package com.example.podcastapp.data.models

import androidx.lifecycle.LiveData
import com.example.podcastapp.data.vos.*

interface PodCastModel {

    fun getAllGenreData(): LiveData<List<GenreVO>>
    fun getAllRandomPodCastData(): LiveData<RandomPodCastVO>
    fun getAllPodCastDetailData(): LiveData<PodCastDetailVO>
    fun getAllUpNextPodCastData(): LiveData<List<UpNextPodCastVO>>

    //get download data from database
    fun getAllDownloadPodCastData() : LiveData<List<UpNextVO>>

    fun getRandomDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
    fun getGenreDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
    fun getUpNextDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
    fun getPodCastDetailDataAndSaveToDatabase(
        id: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )

    //save download data into database
    fun getDownloadedDataAndSaveToDatabase(data: UpNextVO)

}