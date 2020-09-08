package com.example.podcastapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.podcastapp.persistence.typeconverters.UpNextDataTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Up_Next")
@TypeConverters(UpNextDataTypeConverter::class)
data class UpNextPodCastVO(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id: Int = 0,
    @SerializedName("data") var data: UpNextVO = UpNextVO()
)