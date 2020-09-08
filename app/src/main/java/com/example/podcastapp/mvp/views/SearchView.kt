package com.example.podcastapp.mvp.views

import com.example.podcastapp.data.vos.GenreVO

interface SearchView : BaseView {
    fun showGenreData(data: List<GenreVO>)
}