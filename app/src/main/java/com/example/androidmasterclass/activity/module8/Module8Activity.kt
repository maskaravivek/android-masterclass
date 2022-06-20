package com.example.androidmasterclass.activity.module8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidmasterclass.R

class Module8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_8)
        startLesson1()
        startLesson2()
        startLesson3()
        startLesson4()
        startLesson5()
    }

    private fun startLesson1() {
        val button = findViewById<Button>(R.id.module_8_lesson_1)
        button.setOnClickListener {
            val intent = Intent(this, Lesson1RoomPersistenceActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson2() {
        val button = findViewById<Button>(R.id.module_8_lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2RoomModelsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById<Button>(R.id.module_8_lesson_3)
        button.setOnClickListener {
            val intent = Intent(this, Lesson3RoomDaoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson4() {
        val button = findViewById<Button>(R.id.module_8_lesson_4)
        button.setOnClickListener {
            val intent = Intent(this, Lesson4RoomRepositoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson5() {
        val button = findViewById<Button>(R.id.module_8_lesson_5)
        button.setOnClickListener {
            val intent = Intent(this, Lesson5RoomDBAndMigrationActivity::class.java)
            startActivity(intent)
        }
    }
}