package com.example.podcastapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.podcastapp.data.vos.UpNextVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DownloadTypeConverter {
    @TypeConverter
    fun toSting(download: UpNextVO): String {
        return Gson().toJson(download)
    }

    @TypeConverter
    fun toObject(download: String): UpNextVO {
        val downloadType = object : TypeToken<UpNextVO>() {}.type
        return Gson().fromJson(download, downloadType)
    }
}