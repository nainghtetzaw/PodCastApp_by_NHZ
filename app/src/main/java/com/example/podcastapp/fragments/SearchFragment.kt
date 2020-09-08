package com.example.podcastapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.podcastapp.R
import com.example.podcastapp.adapters.GenreAdapter
import com.example.podcastapp.data.vos.GenreVO
import com.example.podcastapp.mvp.presenters.implementations.SearchPresenterImpl
import com.example.podcastapp.mvp.presenters.interfaces.SearchPresenter
import com.example.podcastapp.mvp.views.SearchView
import kotlinx.android.synthetic.main.fragment_search.*

private lateinit var genreAdapter: GenreAdapter
private lateinit var linearLayoutManager: LinearLayoutManager
private lateinit var mPresenter: SearchPresenter

class SearchFragment : Fragment(), SearchView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setUpPresenter()
        activity?.let {
            mPresenter.onUiReady(it.applicationContext, this)
        }
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun showGenreData(data: List<GenreVO>) {
        genreAdapter.setNewData(data.toMutableList())
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SearchPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        genreAdapter = GenreAdapter()
        linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rviewPodcastCategory.adapter = genreAdapter
        rviewPodcastCategory.layoutManager = linearLayoutManager
    }

}