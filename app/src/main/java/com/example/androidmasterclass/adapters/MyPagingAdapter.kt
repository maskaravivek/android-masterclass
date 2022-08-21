package com.example.androidmasterclass.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmasterclass.R
import com.example.androidmasterclass.models.User
import com.example.androidmasterclass.viewholder.MyPagingViewHolder
import com.example.androidmasterclass.viewholder.RecyclerViewHolder

class MyPagingAdapter(diffCallback: DiffUtil.ItemCallback<User>) :
    PagingDataAdapter<User, MyPagingViewHolder>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyPagingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_paging_view_item, parent, false)
        return MyPagingViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyPagingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}