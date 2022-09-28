package com.educative.android.hello.activity.module9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.educative.hello.R

class Module9Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_9)
        startLesson1()
        startLesson2()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_9_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1RetrofitActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson2() {
        val button = findViewById<Button>(R.id.module_9_lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2KotlinCoroutinesActivity::class.java)
            startActivity(intent)
        }
    }
}