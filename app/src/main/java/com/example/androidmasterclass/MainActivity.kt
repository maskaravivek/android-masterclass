package com.example.androidmasterclass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.activity.module2.Module2Activity
import com.example.androidmasterclass.activity.module3.Module3Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startModule3()
    }

    private fun startModule3() {

        val buttonModule2 = findViewById<Button>(R.id.module_2)
        buttonModule2.setOnClickListener {
            val intent = Intent(this, Module2Activity::class.java)
            startActivity(intent)
        }

        val buttonModule3 = findViewById<Button>(R.id.module_3)
        buttonModule3.setOnClickListener {
            val intent = Intent(this, Module3Activity::class.java)
            startActivity(intent)
        }
    }
}