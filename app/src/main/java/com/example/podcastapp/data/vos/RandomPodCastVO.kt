package com.example.podcastapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "Random_PodCast")
data class RandomPodCastVO(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id: String = "",
    @SerializedName("title") var title: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("audio") var audio: String = "",
    @SerializedName("audio_length_sec") var audioLengthSec: Int = 0,
    @SerializedName("image") var image: String = ""
)