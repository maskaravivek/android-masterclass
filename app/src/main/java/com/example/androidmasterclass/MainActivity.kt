package com.example.androidmasterclass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.activity.module10.Module10Activity
import com.example.androidmasterclass.activity.module2.Module2Activity
import com.example.androidmasterclass.activity.module3.Module3Activity
import com.example.androidmasterclass.activity.module6.Module6Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startModule2()
        startModule3()
        startModule6()
        startModule10()
    }

    private fun startModule2() {
        val buttonModule2 = findViewById<Button>(R.id.module_2)
        buttonModule2.setOnClickListener {
            val intent = Intent(this, Module2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule3() {
        val buttonModule3 = findViewById<Button>(R.id.module_3)
        buttonModule3.setOnClickListener {
            val intent = Intent(this, Module3Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule6() {
        val buttonModule6 = findViewById<Button>(R.id.module_6)
        buttonModule6.setOnClickListener {
            val intent = Intent(this, Module6Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule10() {
        val buttonModule10 = findViewById<Button>(R.id.module_10)
        buttonModule10.setOnClickListener {
            val intent = Intent(this, Module10Activity::class.java)
            startActivity(intent)
        }
    }
}