package com.educative.android.hello.activity.module6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.educative.hello.R
import com.educative.android.hello.viewmodel.MyCounterViewModel


class Lesson2ViewModelActivity : AppCompatActivity() {

    private lateinit var myCounterViewModel: MyCounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_6_lesson_1_view_model)

        myCounterViewModel = ViewModelProvider(this)[MyCounterViewModel::class.java]
        attachEvents()
        displayCounterValue()
    }

    private fun attachEvents() {
        val buttonIncrement = findViewById<Button>(R.id.increment)
        buttonIncrement.setOnClickListener {
            myCounterViewModel.incrementCounter()
            displayCounterValue()
        }

        val buttonDecrement = findViewById<Button>(R.id.decrement)
        buttonDecrement.setOnClickListener {
            myCounterViewModel.decrementCounter()
            displayCounterValue()
        }
    }

    private fun displayCounterValue() {
        val tvCounter = findViewById<TextView>(R.id.tv_counter)
        tvCounter.text = myCounterViewModel.getCounter().toString()
    }
}