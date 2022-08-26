package com.educative.android.hello.activity.module7

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.educative.hello.R
import com.educative.android.hello.adapters.MyPagingAdapter
import com.educative.android.hello.comparator.MyPagingComparator
import com.educative.android.hello.viewmodel.MyPagingViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class Lesson4LazyLoadingActivity : AppCompatActivity() {

    private lateinit var myPagingViewModel: MyPagingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_7_lesson_4_lazy_loading)

        myPagingViewModel = ViewModelProvider(this)[MyPagingViewModel::class.java]
        setRecyclerView()
    }

    private fun setRecyclerView() {
        Log.d("Lesson4LazyLoadingActivity", "setting recycler view")
        val pagingAdapter = MyPagingAdapter(MyPagingComparator)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = pagingAdapter
        recyclerView.layoutManager = layoutManager

        lifecycleScope.launch {
            myPagingViewModel.flow.collectLatest { pagingData ->
                pagingAdapter.submitData(pagingData)
            }
        }
    }
}