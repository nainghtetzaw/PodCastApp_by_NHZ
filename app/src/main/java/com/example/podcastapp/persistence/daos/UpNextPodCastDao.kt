package com.example.podcastapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO

@Dao
interface UpNextPodCastDao {

    @Query("SELECT * FROM Up_Next")
    fun getAllDataFromUpNextTable(): LiveData<List<UpNextPodCastVO>>

    @Query("SELECT * FROM Data WHERE id = :podcastid")
    fun getAllDataFromUpNextById(podcastid : String) : LiveData<UpNextVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoUpNextTable(list: List<UpNextPodCastVO>)

}