package com.example.androidmasterclass.activity.module3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import kotlinx.coroutines.delay
import java.util.*


class Lesson3ProcessesAndThreadsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_3_processes_and_threads)
        attachEvents()
    }

    private fun attachEvents() {
        val button1 = findViewById<Button>(R.id.generate_random_bg)
        button1.setOnClickListener {
            generateRandomNumberOnBackgroundThread();
        }

        val button2 = findViewById<Button>(R.id.generate_random_ui)
        button2.setOnClickListener {
            var randomNumber: Int
            while (true) {
                val r = Random()
                val nextNum = r.nextInt(1000000)
                if (nextNum.mod(73) == 0 && nextNum.div(73) == 10) {
                    randomNumber = nextNum
                    break
                }

            }
            val randomNumberTv = findViewById<TextView>(R.id.random_number)
            randomNumberTv.text = randomNumber.toString()
        }
    }

    private fun generateRandomNumberOnBackgroundThread() {
        var randomNumber: Int

        Thread {
            while (true) {
                val r = Random()
                val nextNum = r.nextInt(1000000)
                if (nextNum.mod(44) == 0 && nextNum.div(44) == 10) {
                    randomNumber = nextNum
                    break
                }
            }
            runOnUiThread {
                val randomNumberTv = findViewById<TextView>(R.id.random_number)
                randomNumberTv.text = randomNumber.toString()
            }
        }.start()
    }
}