package com.educative.android.hello.activity.module10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.educative.hello.R

class Module10Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_10)
        startLesson1()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_10_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1SingletonClassActivity::class.java)
            startActivity(intent)
        }
    }
}