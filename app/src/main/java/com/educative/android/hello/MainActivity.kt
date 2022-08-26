package com.educative.android.hello

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.educative.android.hello.activity.module1.Module1Activity
import com.educative.android.hello.activity.module2.Module2Activity
import com.educative.android.hello.activity.module3.Module3Activity
import com.educative.android.hello.activity.module4.Module4Activity
import com.educative.android.hello.activity.module5.Module5Activity
import com.educative.android.hello.activity.module6.Module6Activity
import com.educative.android.hello.activity.module7.Module7Activity
import com.educative.android.hello.activity.module8.Module8Activity
import com.educative.android.hello.activity.module9.Module9Activity
import com.example.educative.hello.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startModule1()
        startModule2()
        startModule3()
        startModule4()
        startModule5()
        startModule6()
        startModule7()
        startModule8()
        startModule9()
    }

    private fun startModule1() {
        val buttonModule1 = findViewById<Button>(R.id.module_1)
        buttonModule1.setOnClickListener {
            val intent = Intent(this, Module1Activity::class.java)
            startActivity(intent)
        }
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

    private fun startModule4() {
        val buttonModule4 = findViewById<Button>(R.id.module_4)
        buttonModule4.setOnClickListener {
            val intent = Intent(this, Module4Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule5() {
        val buttonModule5 = findViewById<Button>(R.id.module_5)
        buttonModule5.setOnClickListener {
            val intent = Intent(this, Module5Activity::class.java)
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

    private fun startModule7() {
        val buttonModule6 = findViewById<Button>(R.id.module_7)
        buttonModule6.setOnClickListener {
            val intent = Intent(this, Module7Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule8() {
        val buttonModule6 = findViewById<Button>(R.id.module_8)
        buttonModule6.setOnClickListener {
            val intent = Intent(this, Module8Activity::class.java)
            startActivity(intent)
        }
    }

    private fun startModule9() {
        val buttonModule9 = findViewById<Button>(R.id.module_9)
        buttonModule9.setOnClickListener {
            val intent = Intent(this, Module9Activity::class.java)
            startActivity(intent)
        }
    }
}