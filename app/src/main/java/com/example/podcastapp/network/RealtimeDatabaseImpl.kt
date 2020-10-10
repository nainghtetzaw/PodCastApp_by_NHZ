package com.example.podcastapp.network

import com.example.podcastapp.data.vos.GenreVO
import com.example.podcastapp.data.vos.RandomPodCastVO
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object RealtimeDatabaseImpl : FirebaseApi  {

    private val database :  DatabaseReference = Firebase.database.reference

//    override fun getAllRandomDataFromFirebase(
//        onSuccess: (RandomPodCastVO) -> Unit,
//        onError: (String) -> Unit
//    ) {
//        database.child("latest_episodes").child("3").addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot){
//                snapshot.children.forEach { datasnapshot ->
//                    datasnapshot.getValue(RandomPodCastVO::class.java)?.let{
//                        onSuccess(it)
//                    }
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                onError(error.message)
//            }
//
//        })
//    }

    override fun getAllPodCastGenreFromFirebase(
        onSuccess: (genres: List<GenreVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        database.child("genres").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val genrelist = arrayListOf<GenreVO>()
                snapshot.children.forEach {datasnapshot ->
                    datasnapshot.getValue(GenreVO::class.java)?.let {
                        genrelist.add(it)
                    }
                }
                onSuccess(genrelist)
            }

            override fun onCancelled(error: DatabaseError) {
                onError(error.message)
            }

        })
    }

    override fun getAllUpNextPodCastFromFirebase(
        onSuccess: (upnext: List<UpNextVO>) -> Unit,
        onError: (String) -> Unit
    ) {
        database.child("latest_episodes").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val upnextlist = arrayListOf<UpNextVO>()
                snapshot.children.forEach {datasnapshot ->
                    datasnapshot.getValue(UpNextVO::class.java)?.let {
                        upnextlist.add(it)
                    }
                }
                onSuccess(upnextlist)
            }

            override fun onCancelled(error: DatabaseError) {
                onError(error.message)
            }

        })
    }

//    override fun getAllDownloadPodCastFromFirebase(
//        onSuccess: (download: List<UpNextVO>) -> Unit,
//        onError: (String) -> Unit
//    ) {
//        database.child("downloads").addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val downloadlist = arrayListOf<UpNextVO>()
//                snapshot.children.forEach {datasnapshot ->
//                    datasnapshot.getValue(UpNextVO::class.java)?.let {
//                        downloadlist.add(it)
//                    }
//                }
//                onSuccess(downloadlist)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                onError(error.message)
//            }
//        })
//
//    }

//    override fun downloadPodCast(upnext: UpNextVO) {
//        database.child("downloads").child(upnext.id).setValue(upnext)
//    }
}