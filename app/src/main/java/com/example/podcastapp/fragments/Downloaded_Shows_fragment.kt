package com.example.podcastapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.podcastapp.R
import com.example.podcastapp.activities.PodCastDetailActivity
import com.example.podcastapp.adapters.YourShowsAdapter
import com.example.podcastapp.mvp.presenters.YourShowPresenter
import com.example.podcastapp.mvp.presenters.YourShowPresenterImpl
import com.example.podcastapp.mvp.views.YourShowView
import kotlinx.android.synthetic.main.fragment_downloaded__shows_fragment.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Downloaded_Shows_fragment : Fragment(),YourShowView {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var yourShowAdapter : YourShowsAdapter
    private lateinit var mPresenter : YourShowPresenter

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Downloaded_Shows_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_downloaded__shows_fragment
            , container
            , false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initPresenter()
        linearLayoutManager = LinearLayoutManager(activity
            ,LinearLayoutManager.VERTICAL
            ,false)
        yourShowAdapter = YourShowsAdapter(mPresenter)
        rviewYourShow.layoutManager = linearLayoutManager
        rviewYourShow.adapter = yourShowAdapter
        super.onViewCreated(view, savedInstanceState)
    }

    override fun navigateToDetail() {
        startActivity(PodCastDetailActivity.newIntent(activity))
    }

    private fun initPresenter(){
        mPresenter = ViewModelProviders.of(this).get(YourShowPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
}