package com.example.podcastapp.delegates

interface DownloadDelegate {
    fun onItemClick(id: String,name : String,description : String,audio: String,audiolength : Int,image : String)
}