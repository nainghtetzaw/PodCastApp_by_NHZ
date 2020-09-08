package com.example.podcastapp.network

import com.example.podcastapp.data.vos.PodCastDetailVO
import com.example.podcastapp.data.vos.RandomPodCastVO
import com.example.podcastapp.network.responses.GenreResponse
import com.example.podcastapp.network.responses.UpNextResponse
import com.example.podcastapp.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface PodcastApi {

    @GET(GET_RANDOM_PODCAST)
    fun getRandomDataResponse(@Header(X_LISTENAPI_KEY) apikey: String): Observable<RandomPodCastVO>

    @GET(GET_PODCAST_GENRES)
    fun getPodCastGenreResponse(
        @Header(X_LISTENAPI_KEY) apikey: String,
        @Query(TOP_LEVEL_ONLY) top: Int
    ): Observable<GenreResponse>

    @GET("$GET_UPNEXT_PODCAST/{id}")
    fun getUpNextPodCastResponse(
        @Header(X_LISTENAPI_KEY) apikey: String,
        @Path("id") id: String,
        @Query(TYPE) type: String,
        @Query(LAST_TIMESTAMP_MS) timeStamp: Int,
        @Query(SORT) sort: String
    ): Observable<UpNextResponse>

    @GET("$GET_PODCAST_DETAIL/{id}")
    fun getPodCastDetailResponse(
        @Header(X_LISTENAPI_KEY) apikey: String,
        @Path("id") podcastId: String
    ): Observable<PodCastDetailVO>
}