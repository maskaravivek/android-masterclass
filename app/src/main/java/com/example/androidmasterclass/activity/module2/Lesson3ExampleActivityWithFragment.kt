package com.example.androidmasterclass.activity.module2

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.androidmasterclass.R

class Lesson3ExampleActivityWithFragment : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_module_2_lesson_3_fragments)
    }

}
