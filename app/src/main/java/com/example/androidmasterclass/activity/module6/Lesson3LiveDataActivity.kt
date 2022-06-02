package com.example.androidmasterclass.activity.module6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidmasterclass.R
import com.example.androidmasterclass.viewmodel.MyCounterViewModelWithLiveData


class Lesson3LiveDataActivity : AppCompatActivity() {

    private lateinit var myCounterViewModel: MyCounterViewModelWithLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_6_lesson_1_view_model)

        myCounterViewModel = ViewModelProvider(this)[MyCounterViewModelWithLiveData::class.java]
        lifecycle.addObserver(myCounterViewModel)
        myCounterViewModel.myCounter.observe(this) {
            val tvCounter = findViewById<TextView>(R.id.tv_counter)
            tvCounter.text = it.toString()
        }
        attachEvents()
    }

    private fun attachEvents() {
        val buttonIncrement = findViewById<Button>(R.id.increment)
        buttonIncrement.setOnClickListener {
            myCounterViewModel.incrementCounter()
        }

        val buttonDecrement = findViewById<Button>(R.id.decrement)
        buttonDecrement.setOnClickListener {
            myCounterViewModel.decrementCounter()
        }
    }
}