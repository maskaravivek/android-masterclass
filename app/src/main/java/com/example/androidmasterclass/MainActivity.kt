package com.example.androidmasterclass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.activity.module9.Module9Activity
import com.example.androidmasterclass.activity.module1.Module1Activity
import com.example.androidmasterclass.activity.module2.Module2Activity
import com.example.androidmasterclass.activity.module5.Module5Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startModule1()
        startModule2()
        startModule5()
        startModule9()
    }

    private fun startModule1() {
        val buttonModule2 = findViewById<Button>(R.id.module_1)
        buttonModule2.setOnClickListener {
            val intent = Intent(this, Module1Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule2() {
        val buttonModule3 = findViewById<Button>(R.id.module_2)
        buttonModule3.setOnClickListener {
            val intent = Intent(this, Module2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule5() {
        val buttonModule6 = findViewById<Button>(R.id.module_5)
        buttonModule6.setOnClickListener {
            val intent = Intent(this, Module5Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule9() {
        val buttonModule10 = findViewById<Button>(R.id.module_9)
        buttonModule10.setOnClickListener {
            val intent = Intent(this, Module9Activity::class.java)
            startActivity(intent)
        }
    }
}