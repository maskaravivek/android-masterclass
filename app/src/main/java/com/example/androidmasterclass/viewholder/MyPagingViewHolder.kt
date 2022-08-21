package com.example.androidmasterclass.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmasterclass.R
import com.example.androidmasterclass.models.User

class MyPagingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: User?) {
        userNameTextView.text = item?.username
        userEmailTextView.text = item?.email
    }

    val userNameTextView: TextView
    val userEmailTextView: TextView

    init {
        // Define click listener for the ViewHolder's View.
        userNameTextView = view.findViewById(R.id.paging_user_tv)
        userEmailTextView = view.findViewById(R.id.paging_email_tv)
    }
}