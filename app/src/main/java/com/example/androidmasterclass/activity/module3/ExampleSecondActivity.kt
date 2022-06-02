package com.example.androidmasterclass.activity.module3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.example.androidmasterclass.viewmodel.CounterLifecycleObserver

class ExampleSecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson1_second_activity)
    }
}