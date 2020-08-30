package com.example.podcastapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.podcastapp.R
import com.example.podcastapp.adapters.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_search.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var categoryAdapter : CategoryAdapter
private lateinit var linearLayoutManager: LinearLayoutManager

class SearchFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    private fun setUpRecyclerView(){
        categoryAdapter = CategoryAdapter()
        linearLayoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        rviewPodcastCategory.adapter = categoryAdapter
        rviewPodcastCategory.layoutManager = linearLayoutManager
    }

}