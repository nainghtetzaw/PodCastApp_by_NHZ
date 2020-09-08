package com.example.podcastapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.podcastapp.R
import com.example.podcastapp.activities.PodCastDetailActivity
import com.example.podcastapp.adapters.DowndloadedShowsAdapter
import com.example.podcastapp.data.vos.UpNextPodCastVO
import com.example.podcastapp.data.vos.UpNextVO
import com.example.podcastapp.mvp.presenters.implementations.DownloadedShowPresenterImpl
import com.example.podcastapp.mvp.presenters.interfaces.DownloadedShowPresenter
import com.example.podcastapp.mvp.views.DownloadedShowsView
import kotlinx.android.synthetic.main.fragment_downloaded__shows_fragment.*

class DownloadedShowsFragment : Fragment(), DownloadedShowsView {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var yourShowAdapter: DowndloadedShowsAdapter
    private lateinit var mPresenter: DownloadedShowPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_downloaded__shows_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initPresenter()
        setUpRecyclerView()

        mPresenter.onUiReady(this)

        super.onViewCreated(view, savedInstanceState)
    }

    override fun navigateToDetail(id: String) {
        startActivity(PodCastDetailActivity.newIntent(activity, id))
    }

    override fun showDownloadedData(data: List<UpNextVO>) {
        yourShowAdapter.setNewData(data.toMutableList())
    }

    private fun initPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DownloadedShowPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        yourShowAdapter = DowndloadedShowsAdapter(mPresenter)
        rviewYourShow.layoutManager = linearLayoutManager
        rviewYourShow.adapter = yourShowAdapter
    }
}