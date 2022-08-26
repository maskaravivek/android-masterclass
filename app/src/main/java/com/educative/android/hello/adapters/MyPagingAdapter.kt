package com.educative.android.hello.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.educative.hello.R
import com.educative.android.hello.models.User
import com.educative.android.hello.viewholder.MyPagingViewHolder

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