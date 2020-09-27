package com.example.podcastapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "Data")
data class UpNextVO(
    @PrimaryKey
    @SerializedName("id") var id: String = "",
    @SerializedName("title") var title: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("audio") var audio: String = "",
    @SerializedName("audio_length_sec") var audio_length_sec: Int = 0,
    @SerializedName("image") var image: String = ""
)