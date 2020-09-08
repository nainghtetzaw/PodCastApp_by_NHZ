package com.example.podcastapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.podcastapp.data.vos.UpNextPodCastVO

@Dao
interface UpNextPodCastDao {

    @Query("SELECT * FROM Up_Next")
    fun getAllDataFromUpNextTable(): LiveData<List<UpNextPodCastVO>>

    @Query("SELECT * FROM Up_Next WHERE id = :podcastid")
    fun getAllDataFromUpNextById(podcastid : Int) : LiveData<List<UpNextPodCastVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoUpNextTable(list: List<UpNextPodCastVO>)

}