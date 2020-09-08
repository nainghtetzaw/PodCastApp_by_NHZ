package com.example.podcastapp.data.vos

import com.google.gson.annotations.SerializedName

data class RandomVO(
    @SerializedName("title") var podcastTitle: String = ""
)