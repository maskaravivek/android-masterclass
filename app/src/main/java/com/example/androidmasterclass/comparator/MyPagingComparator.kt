package com.example.androidmasterclass.comparator

import androidx.recyclerview.widget.DiffUtil
import com.example.androidmasterclass.models.User

object MyPagingComparator : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        // Id is unique.
        return oldItem.email == newItem.email
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}