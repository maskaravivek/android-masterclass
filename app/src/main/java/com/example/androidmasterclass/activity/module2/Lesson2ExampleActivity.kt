package com.example.androidmasterclass.activity.module2

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView
import com.example.androidmasterclass.R

class Lesson2ExampleActivity : Activity() {
    private lateinit var tvCounter: AppCompatTextView
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_example_2_lesson)
        tvCounter = findViewById(R.id.tv_counter)
    }

    override fun onResume() {
        super.onResume()
        count++
        tvCounter.setText(count)
    }

}