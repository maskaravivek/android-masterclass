package com.educative.android.hello.activity.module6

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.educative.hello.R
import com.educative.android.hello.viewmodel.CounterLifecycleObserver

class Lesson1ExampleLifecycleOwnerActivity : AppCompatActivity() {

    private lateinit var myCounterLifecycleObserver: CounterLifecycleObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_6_lesson_1_view_model)

        myCounterLifecycleObserver = CounterLifecycleObserver()
        this.lifecycle.addObserver(myCounterLifecycleObserver)

        attachEvents()
        displayCounterValue()
    }

    override fun onResume() {
        displayCounterValue()
        super.onResume()
    }

    private fun attachEvents() {
        val buttonIncrement = findViewById<Button>(R.id.increment)
        buttonIncrement.setOnClickListener {
            myCounterLifecycleObserver.incrementCounter()
            displayCounterValue()
        }

        val buttonDecrement = findViewById<Button>(R.id.decrement)
        buttonDecrement.setOnClickListener {
            myCounterLifecycleObserver.decrementCounter()
            displayCounterValue()
        }
    }

    private fun displayCounterValue() {
        val tvCounter = findViewById<TextView>(R.id.tv_counter)
        tvCounter.text = myCounterLifecycleObserver.getCounter().toString()
    }
}