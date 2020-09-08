package com.example.podcastapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.podcastapp.data.vos.PodCastDetailVO

@Dao
interface PodCastDetailDao {

    @Query("SELECT * FROM PODCAST_DETAIL")
    fun getAllDataFromPodCastDetailTable(): LiveData<PodCastDetailVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoPodCastDetailTable(podcastDetail: PodCastDetailVO)

}