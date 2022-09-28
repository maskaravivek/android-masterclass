package com.educative.android.hello.activity.module2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.educative.hello.R
import com.educative.android.hello.adapters.RecyclerViewAdapter

class RecyclerViewActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val dataset: ArrayList<String> = arrayListOf("green", "red", "blue")
        val adapter = RecyclerViewAdapter(dataset)
        val layoutManager = LinearLayoutManager(applicationContext)
        var recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}