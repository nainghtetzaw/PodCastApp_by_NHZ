package com.example.podcastapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.podcastapp.data.vos.UpNextVO

@Dao
interface DownloadDao {

    @Query("SELECT * FROM Data")
    fun getAllDownloadDataFromDownloadTable() : LiveData<List<UpNextVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoDownloadTable(data : UpNextVO)
}