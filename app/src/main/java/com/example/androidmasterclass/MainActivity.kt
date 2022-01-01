package com.example.androidmasterclass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.activity.module3.Module3Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startModule3()
    }

    private fun startModule3() {
        val button = findViewById(R.id.module_3) as Button
        button.setOnClickListener {
            val intent = Intent(this, Module3Activity::class.java)
            startActivity(intent)
        }
    }
}