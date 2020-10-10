package com.example.podcastapp.delegates

import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO

interface PodcastDelegate {
    fun onItemClick(id: String,name : String,description : String,audio: String,audiolength : Int,image : String)
    fun onDownloadClick(data : UpNextVO)
}