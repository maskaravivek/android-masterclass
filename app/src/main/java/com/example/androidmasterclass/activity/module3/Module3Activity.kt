package com.example.androidmasterclass.activity.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidmasterclass.R

class Module3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3)
        startLesson1()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_3_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1ExampleActivity::class.java)
            startActivity(intent)
        }
    }
}