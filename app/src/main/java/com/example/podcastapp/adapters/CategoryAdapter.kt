package com.example.podcastapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.podcastapp.R
import com.example.podcastapp.views.viewholders.CategoryViewholder

class CategoryAdapter : RecyclerView.Adapter<CategoryViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewholder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: CategoryViewholder, position: Int) {

    }
}