package com.educative.android.hello.activity.module1

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.educative.hello.R

class Lesson3ExampleActivityWithFragment : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_activity_module_1_lesson_3_fragments)
    }

}
