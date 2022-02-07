package com.example.androidmasterclass.activity.module6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Module6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_6)
        startLesson1()
    }

    private fun startLesson1() {
        val button = findViewById(R.id.module_6_lesson_1) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson1FirebaseAuth::class.java)
            startActivity(intent)
        }
    }
}