package com.example.podcastapp.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.podcastapp.data.vos.RandomVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RandomTypeConverters {

    @TypeConverter
    fun toString(data: RandomVO): String {
        return Gson().toJson(data)
    }

    @TypeConverter
    fun toObject(data: String): RandomVO {
        val dataType = object : TypeToken<RandomVO>() {}.type
        return Gson().fromJson(data, dataType)
    }
}