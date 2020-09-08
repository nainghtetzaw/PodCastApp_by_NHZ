package com.example.podcastapp.delegates

import com.example.podcastapp.data.vos.UpNextPodCastVO

interface PodcastDelegate {
    fun onItemClick(id: String)
    fun onDownloadClick(data : UpNextPodCastVO)
}