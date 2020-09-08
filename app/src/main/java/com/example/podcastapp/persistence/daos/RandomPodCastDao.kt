package com.example.podcastapp.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.podcastapp.data.vos.RandomPodCastVO

@Dao
interface RandomPodCastDao {

    @Query("SELECT * From Random_PodCast")
    fun getAllFromRandomPodCastTable(): LiveData<RandomPodCastVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoRandomPodCastTable(podcast: RandomPodCastVO)
}