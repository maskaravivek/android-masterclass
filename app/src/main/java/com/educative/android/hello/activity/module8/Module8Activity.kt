package com.educative.android.hello.activity.module8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.educative.hello.R

class Module8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_8)
        startLesson5()
    }

    private fun startLesson5() {
        val button = findViewById<Button>(R.id.module_8_lesson_5)
        button.setOnClickListener {
            val intent = Intent(this, Lesson5RoomDBActivity::class.java)
            startActivity(intent)
        }
    }
}