package com.example.androidmasterclass.activity.module1

import android.app.Activity
import android.os.Bundle
import com.example.androidmasterclass.R

class Lesson4ExampleActivityWithInfoView : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_1_lesson_4_custom_view)
    }
}