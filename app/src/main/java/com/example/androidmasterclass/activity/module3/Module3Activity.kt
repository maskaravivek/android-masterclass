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
        startLesson2()
        startLesson3()
        startLesson4()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_3_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1IntentsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson2() {
        val button = findViewById<Button>(R.id.module_3_lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2BroadcastReceiverActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById<Button>(R.id.module_3_lesson_3)
        button.setOnClickListener {
            val intent = Intent(this, Lesson3ProcessesAndThreadsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson4() {
        val button = findViewById<Button>(R.id.module_3_lesson_4)
        button.setOnClickListener {
            val intent = Intent(this, Lesson4ServiceAndWorkersActivity::class.java)
            startActivity(intent)
        }
    }
}