package com.example.podcastapp.data.models

import androidx.lifecycle.LiveData
import com.example.podcastapp.data.vos.*

interface PodCastModel {

//    fun getAllGenreData(): LiveData<List<GenreVO>>
//    fun getAllRandomPodCastData(): LiveData<RandomPodCastVO>
//    fun getAllUpNextPodCastData(): LiveData<List<UpNextPodCastVO>>
//    fun getPodCastDetailData(id: String) : LiveData<UpNextVO>
//
//    //get download data from database
//    fun getAllDownloadPodCastData() : LiveData<List<UpNextVO>>
//
//    fun getRandomDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
//    fun getGenreDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
//    fun getUpNextDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit)
//
//    //save download data into database
//    fun getDownloadedDataAndSaveToDatabase(data: UpNextVO)

    fun getRandomPodCastData(onSuccess : (RandomPodCastVO) -> Unit,onError : (String) -> Unit)
    fun getGenrePodCastData(onSuccess : (genres : List<GenreVO>) -> Unit,onError: (String) -> Unit)
    fun getUpNextPodCastData(onSuccess: (upnext: List<UpNextVO>) -> Unit,onError: (String) -> Unit)
    fun getDownloadPoeCastData(onSuccess: (download: List<UpNextVO>) -> Unit, onError: (String) -> Unit)
    fun getPodCastDetailData(id : String,onSuccess: (UpNextVO) -> Unit,onError: (String) -> Unit)
    fun downloadPodCastData(upnext : UpNextVO)
}