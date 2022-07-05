package com.example.androidmasterclass.activity.module3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
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
            val startTime = System.currentTimeMillis()
            val requiredNum = longRunningTask()
            val timetaken = System.currentTimeMillis() - startTime;
            val randomNumberTv = findViewById<TextView>(R.id.random_number)
            randomNumberTv.text = requiredNum.toString()

            val timeTakenTv = findViewById<TextView>(R.id.time_taken)
            timeTakenTv.text = timetaken.toString()
        }
    }

    private fun longRunningTask(): Int {
        var requiredNum = 0
        for (i in 1..10) {
            requiredNum = requiredRandomNumber()
            for (i in 1..requiredNum) {
                //do nothing
            }
        }
        return requiredNum
    }

    private fun requiredRandomNumber(): Int {
        var randomNum = 0
        while (true) {
            val r = Random()
            val nextNum = r.nextInt(1000000000)
            if (nextNum >= 900000000) {
                randomNum = nextNum
                break
            }
        }
        return randomNum
    }

    private fun generateRandomNumberOnBackgroundThread() {
        val startTime = System.currentTimeMillis()
        Thread {
            val requiredNum = longRunningTask()
            val timetaken = System.currentTimeMillis() - startTime;
            runOnUiThread {
                val randomNumberTv = findViewById<TextView>(R.id.random_number)
                randomNumberTv.text = requiredNum.toString()

                val timeTakenTv = findViewById<TextView>(R.id.time_taken)
                timeTakenTv.text = timetaken.toString()
            }
        }.start()
    }
}