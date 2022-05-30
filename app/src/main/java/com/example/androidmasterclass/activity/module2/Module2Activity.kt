package com.example.androidmasterclass.activity.module2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Module2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3)
        startLesson1()
        startLesson2()
        startLesson3()
        startLesson4()
        startLesson5()
        startLesson6()
    }

    private fun startLesson1() {
        val button = findViewById(R.id.lesson_1) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson1BottomNavigationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson2() {
        val button = findViewById(R.id.lesson_2) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson2DialogActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById(R.id.lesson_3) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson3ImagesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson4() {
        val button = findViewById(R.id.lesson_4) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson4MenuActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson5() {
        val button = findViewById(R.id.lesson_5) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson5RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson6() {
        val button = findViewById(R.id.lesson_6) as Button
        button.setOnClickListener {
            val intent = Intent(this, Lesson6WebviewActivity::class.java)
            startActivity(intent)
        }
    }
}