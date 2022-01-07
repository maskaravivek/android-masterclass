package com.example.androidmasterclass.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmasterclass.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView

    init {
        // Define click listener for the ViewHolder's View.
        textView = view.findViewById(R.id.rv_textview)
    }
}