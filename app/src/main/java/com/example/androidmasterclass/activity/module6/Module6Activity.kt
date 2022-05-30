package com.example.androidmasterclass.activity.module6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidmasterclass.R

class Module6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_9)
        startLesson1()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_6_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1ViewModelActivity::class.java)
            startActivity(intent)
        }
    }
}