package com.example.podcastapp.network

import com.example.podcastapp.data.vos.GenreVO
import com.example.podcastapp.data.vos.UpNextVO
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FireStoreDatabaseImpl : FirebaseApi {

    val db = Firebase.firestore

    override fun getAllPodCastGenreFromFirebase(
        onSuccess: (genres: List<GenreVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        db.collection("genres")
            .addSnapshotListener{value, error ->
                error?.let {
                    onError(it.message ?: "Please Check Connection")
                } ?: kotlin.run {
                    val genreList : MutableList<GenreVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (documents in result){
                        val data = documents.data
                        val genre = GenreVO()
                        genre.id = (data?.get("id") as Long).toInt()
                        genre.name = data.get("name") as String
                        genre.parentId = (data.get("parent_id") as Long).toInt()
                        genreList.add(genre)
                    }
                    onSuccess(genreList)
                }
            }
    }

    override fun getAllUpNextPodCastFromFirebase(
        onSuccess: (upnext: List<UpNextVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        db.collection("latest_episodes")
            .addSnapshotListener{value,error ->
                error?.let {
                    onError(it.message ?: "Please Check Connection")
                } ?: kotlin.run {
                    val upNextList : MutableList<UpNextVO> = arrayListOf()
                    val result = value?.documents ?: arrayListOf()

                    for (documents in result){
                        val data = documents.data
                        val upNext = UpNextVO()
                        upNext.audio = data?.get("audio") as String
                        upNext.audio_length_sec = (data.get("audio_length_sec") as Long).toInt()
                        upNext.description = data.get("description") as String
                        upNext.id = data.get("id") as String
                        upNext.image = data.get("image") as String
                        upNext.title = data.get("title") as String

                        upNextList.add(upNext)
                    }
                    onSuccess(upNextList)
                }
            }
    }

}