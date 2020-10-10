package com.example.podcastapp.network

import com.example.podcastapp.data.vos.GenreVO
import com.example.podcastapp.data.vos.RandomPodCastVO
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO

interface FirebaseApi {
//    fun getAllRandomDataFromFirebase(onSuccess : (RandomPodCastVO) -> Unit,onError : (String) -> Unit)
    fun getAllPodCastGenreFromFirebase(onSuccess : (genres : List<GenreVO>) -> Unit,onError: (String) -> Unit)
    fun getAllUpNextPodCastFromFirebase(onSuccess : (upnext : List<UpNextVO>) -> Unit,onError: (String) -> Unit)
//    fun getAllDownloadPodCastFromFirebase(onSuccess: (download: List<UpNextVO>) -> Unit,onError: (String) -> Unit)

//    fun downloadPodCast(upnext : UpNextVO)
}