package com.educative.android.hello.activity.module4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.educative.hello.R

class Module4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_4)
        startLesson2()
        startLesson3()
        startLesson4()
    }

    private fun startLesson2() {
        val button = findViewById<Button>(R.id.module_4_lesson_2)
        button.setOnClickListener {
            val intent = Intent(this, Lesson2DeclaringManifestPermissionsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson3() {
        val button = findViewById<Button>(R.id.module_4_lesson_3)
        button.setOnClickListener {
            val intent = Intent(this, Lesson3RuntimePermissionsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startLesson4() {
        val button = findViewById<Button>(R.id.module_4_lesson_4)
        button.setOnClickListener {
            val intent = Intent(this, Lesson4UserLocationActivity::class.java)
            startActivity(intent)
        }
    }
}