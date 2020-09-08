package com.example.podcastapp.network.responses

import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.google.gson.annotations.SerializedName

data class UpNextResponse(
    @SerializedName("id") var id: String = "",
    @SerializedName("name") var name: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("image") var image: String = "",
    @SerializedName("thumbnail") var thumnnail: String = "",
    @SerializedName("items") var items: List<UpNextPodCastVO> = listOf()
)