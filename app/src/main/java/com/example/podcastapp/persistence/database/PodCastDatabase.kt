package com.example.podcastapp.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.podcastapp.data.vos.*
import com.example.podcastapp.persistence.daos.*

//@Database(
//    entities = [RandomPodCastVO::class, UpNextPodCastVO::class, PodCastDetailVO::class, GenreVO::class,UpNextVO::class],
//    version = 16,
//    exportSchema = false
//)
abstract class PodCastDatabase : RoomDatabase() {

    companion object {

        val DB_NAME = "PodCast_Database"
        var dbInstance: PodCastDatabase? = null

        fun getDbInstance(context: Context): PodCastDatabase {
            when (dbInstance) {
                null -> {
                    dbInstance = Room.databaseBuilder(context, PodCastDatabase::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return dbInstance!!
        }
    }

    abstract fun downloadPodCastDao() : DownloadDao
    abstract fun randomPodCastDao(): RandomPodCastDao
    abstract fun upNextPodCastDao(): UpNextPodCastDao
    abstract fun podCastDetailDao(): PodCastDetailDao
    abstract fun genreDao(): GenreDao

}