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
        startLesson2()
        startLesson3()
    }

    private fun startLesson2() {
        val button = findViewById<Button>(R.id.module_10_lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2HiltExampleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById<Button>(R.id.module_10_lesson_3)
        button.setOnClickListener {
            val intent = Intent(this, Lesson3HiltModuleActivity::class.java)
            startActivity(intent)
        }
    }
}