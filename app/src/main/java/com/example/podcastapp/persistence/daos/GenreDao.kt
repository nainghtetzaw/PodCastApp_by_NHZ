package com.example.podcastapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.podcastapp.data.vos.GenreVO

@Dao
interface GenreDao {

    @Query("SELECT * FROM Genre")
    fun getAllDataFromGenreTable(): LiveData<List<GenreVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoGenreTable(genre: List<GenreVO>)

}