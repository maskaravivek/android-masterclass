package com.educative.android.hello.activity.module7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.educative.hello.R

class Module7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_7)
        startLesson1()
        startLesson2()
        startLesson3()
        startLesson4()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_7_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1WorkManagerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson2() {
        val button = findViewById<Button>(R.id.module_7_lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2CameraXActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById<Button>(R.id.module_7_lesson_3)
        button.setOnClickListener {
            val intent = Intent(this, Lesson3NavigationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson4() {
        val button = findViewById<Button>(R.id.module_7_lesson_4)
        button.setOnClickListener {
            val intent = Intent(this, Lesson4LazyLoadingActivity::class.java)
            startActivity(intent)
        }
    }
}