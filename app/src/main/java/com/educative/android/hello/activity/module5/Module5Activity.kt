package com.educative.android.hello.activity.module5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.educative.hello.R

class Module5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_5)
        startLesson1()
        startLesson2()
        startLesson3()
        startLesson4()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_5_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1FirebaseAuth::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson2() {
        val button = findViewById<Button>(R.id.module_5_lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2FirebaseRealtimeDatabase::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById<Button>(R.id.module_5_lesson_3)
        button.setOnClickListener {
            val intent = Intent(this, Lesson3FirebaseStorage::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson4() {
        val button = findViewById<Button>(R.id.module_5_lesson_4)
        button.setOnClickListener {
            val intent = Intent(this, Lesson4FirebaseCloudMessaging::class.java)
            startActivity(intent)
        }
    }
}