package com.educative.android.hello.activity.module1

import android.app.Activity
import android.os.Bundle
import com.example.educative.hello.R

class Lesson4ActivityWithCustomView : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module_1_lesson_4_custom_view)
    }

}
