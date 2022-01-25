package com.example.androidmasterclass.activity.module2

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.androidmasterclass.R

class Lesson2ExampleActivity : Activity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_2_lesson_2)
    }

    override fun onResume() {
        super.onResume()
        count++
        updateCounter()
    }

    private fun updateCounter() {
        val tvCounter = findViewById(R.id.tv_counter) as TextView
        tvCounter.setText(count.toString())
    }

}
