package com.example.androidmasterclass.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmasterclass.R
import com.example.androidmasterclass.viewholder.RecyclerViewHolder

class RecyclerViewAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<RecyclerViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.view_holder_simple_recycler_view_item, viewGroup, false)

        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}