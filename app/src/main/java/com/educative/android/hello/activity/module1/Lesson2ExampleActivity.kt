package com.educative.android.hello.activity.module1

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.example.educative.hello.R

class Lesson2ExampleActivity : Activity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_1_lesson_2)
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
