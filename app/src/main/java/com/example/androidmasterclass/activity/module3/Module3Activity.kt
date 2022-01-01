package com.example.androidmasterclass.activity.module3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Module3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3)
        startLesson2()
    }

    private fun startLesson2() {
        val button = findViewById(R.id.lesson_2) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson2DialogActivity::class.java)
            startActivity(intent)
        }
    }
}