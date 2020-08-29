package com.example.podcastapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.podcastapp.R
import com.example.podcastapp.delegates.PodcastDelegate
import com.example.podcastapp.views.viewholders.YourShowsViewHolder

class YourShowsAdapter(delegate : PodcastDelegate) : RecyclerView.Adapter<YourShowsViewHolder>() {

    private val mDelegate : PodcastDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourShowsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_your_shows,parent,false)
        return YourShowsViewHolder(view,mDelegate)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: YourShowsViewHolder, position: Int) {

    }
}