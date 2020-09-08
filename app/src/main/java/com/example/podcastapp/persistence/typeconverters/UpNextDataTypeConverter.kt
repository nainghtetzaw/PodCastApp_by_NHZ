package com.example.podcastapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.podcastapp.data.vos.UpNextVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UpNextDataTypeConverter {

    @TypeConverter
    fun toString(data: UpNextVO): String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun toObject(data: String): UpNextVO {
        val dataType = object : TypeToken<UpNextVO>() {}.type
        return Gson().fromJson(data, dataType)
    }
}