package com.example.share

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : com.example.share.BaseViewholder<W>,W> : RecyclerView.Adapter<T>() {

    var mData : MutableList<W> = mutableListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setNewData(data: MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }
}