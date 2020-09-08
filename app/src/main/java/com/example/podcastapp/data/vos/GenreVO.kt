package com.example.podcastapp.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Genre")
data class GenreVO(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("parent_id") var parentId: Int = 0
)