package com.example.androidmasterclass.activity.module2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Module2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_2)
        startLesson2()
        startLesson3()
        startLesson4()
    }


    private fun startLesson2() {
        val button = findViewById<Button>(R.id.lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2ExampleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById<Button>(R.id.lesson_3)
        button.setOnClickListener {
            val intent = Intent(this, Lesson3ExampleActivityWithFragment::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson4() {
        val button = findViewById<Button>(R.id.lesson_4)
        button.setOnClickListener {
            val intent = Intent(this, Lesson4ActivityWithCustomView::class.java)
            startActivity(intent)
        }
    }

}