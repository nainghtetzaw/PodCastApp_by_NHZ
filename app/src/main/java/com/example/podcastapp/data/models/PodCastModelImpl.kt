package com.example.podcastapp.data.models

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.podcastapp.data.vos.*
import com.example.podcastapp.utils.PARAM_API_KEY
import com.example.podcastapp.utils.PARAM_LIST_KEY
import com.example.podcastapp.utils.PARAM_SORT
import com.example.podcastapp.utils.PARAM_TYPE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastModelImpl : BaseModel(), PodCastModel {

    override fun getAllRandomPodCastData(): LiveData<RandomPodCastVO> {
        return mPodCastDb.randomPodCastDao().getAllFromRandomPodCastTable()
    }

    override fun getAllUpNextPodCastData(): LiveData<List<UpNextPodCastVO>> {
        return mPodCastDb.upNextPodCastDao().getAllDataFromUpNextTable()
    }

    override fun getAllDownloadPodCastData(): LiveData<List<UpNextVO>> {
        return mPodCastDb.downloadPodCastDao().getAllDownloadDataFromDownloadTable()
    }

    override fun getRandomDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mPodCastApi.getRandomDataResponse(PARAM_API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mPodCastDb.randomPodCastDao().insertDataIntoRandomPodCastTable(it)
            }, {
                Log.e("TAG", it.localizedMessage)
                onError(it.localizedMessage ?: "Network fail")
            })
    }

    override fun getGenreDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mPodCastApi.getPodCastGenreResponse(PARAM_API_KEY, 0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mPodCastDb.genreDao().insertDataIntoGenreTable(it.genres)
            }, {
                Log.e("TAG", it.localizedMessage)
                onError(it.localizedMessage ?: "Network fail")
            })
    }

    override fun getUpNextDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        mPodCastApi.getUpNextPodCastResponse(
            PARAM_API_KEY,
            PARAM_LIST_KEY,
            PARAM_TYPE,
            0,
            PARAM_SORT
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mPodCastDb.upNextPodCastDao().insertDataIntoUpNextTable(it.items)
            }, {
                Log.e("TAG", it.localizedMessage)
                onError(it.localizedMessage ?: "Network fail")
            })

    }

    override fun getAllPodCastDetailData(): LiveData<PodCastDetailVO> {
        return mPodCastDb.podCastDetailDao().getAllDataFromPodCastDetailTable()
    }

    override fun getAllGenreData(): LiveData<List<GenreVO>> {
        return mPodCastDb.genreDao().getAllDataFromGenreTable()
    }

    override fun getPodCastDetailDataAndSaveToDatabase(
        id: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        mPodCastApi.getPodCastDetailResponse(
            PARAM_API_KEY,
            id
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mPodCastDb.podCastDetailDao().insertDataIntoPodCastDetailTable(it)
            }, {
                Log.e("TAG", it.localizedMessage)
                onError(it.localizedMessage ?: "Network fail")
            })
    }

    override fun getDownloadedDataAndSaveToDatabase(data: UpNextVO) {
        mPodCastDb.downloadPodCastDao().insertDataIntoDownloadTable(data)
    }

}