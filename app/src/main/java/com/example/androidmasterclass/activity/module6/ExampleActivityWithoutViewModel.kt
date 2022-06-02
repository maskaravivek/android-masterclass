package com.example.androidmasterclass.activity.module6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class ExampleActivityWithoutViewModel : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_6_lesson_1_view_model)

        attachEvents()
    }

    private fun attachEvents() {
        val buttonIncrement = findViewById<Button>(R.id.increment)
        buttonIncrement.setOnClickListener {
            count++
            displayCounterValue()
        }

        val buttonDecrement = findViewById<Button>(R.id.decrement)
        buttonDecrement.setOnClickListener {
            count--
            displayCounterValue()
        }
    }

    private fun displayCounterValue() {
        val tvCounter = findViewById<TextView>(R.id.tv_counter)
        tvCounter.text = count.toString()
    }
}