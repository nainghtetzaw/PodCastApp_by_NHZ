package com.example.podcastapp.network.responses

import com.example.podcastapp.data.vos.GenreVO
import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres") var genres: List<GenreVO> = listOf()
)