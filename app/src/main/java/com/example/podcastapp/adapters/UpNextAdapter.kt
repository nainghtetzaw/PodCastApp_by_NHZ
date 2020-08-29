package com.example.podcastapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.podcastapp.R
import com.example.podcastapp.views.viewholders.BaseViewholder
import com.example.podcastapp.views.viewholders.UpNextViewHolder

class UpNextAdapter : RecyclerView.Adapter<UpNextViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpNextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_up_next,parent,false)
        return UpNextViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: UpNextViewHolder, position: Int) {

    }
}