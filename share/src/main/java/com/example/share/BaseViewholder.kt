package com.example.share

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewholder<T>(itemview: View) : RecyclerView.ViewHolder(itemview) {

    var mData: T? = null

    abstract fun bindData(data: T)

}