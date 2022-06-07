package com.example.androidmasterclass.activity.module3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.androidmasterclass.R
import com.example.androidmasterclass.service.MyCustomService
import com.example.androidmasterclass.worker.GenerateRandomNumberWorker


class Lesson4ServiceAndWorkersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_4_service_and_workers)
        attachEvents()
    }

    private fun attachEvents() {
        val button1 = findViewById<Button>(R.id.start_service)
        button1.setOnClickListener {
            val intent = Intent(this, MyCustomService::class.java)
            intent.putExtra("message", "Hi Educative!")
            startService(intent)
        }

        val button2 = findViewById<Button>(R.id.stop_service)
        button2.setOnClickListener {
            val intent = Intent(this, MyCustomService::class.java)
            stopService(intent)
        }

        val button3 = findViewById<Button>(R.id.run_worker_once)
        button3.setOnClickListener {
            val randomNumberWorker: WorkRequest =
                OneTimeWorkRequestBuilder<GenerateRandomNumberWorker>()
                    .build()
            WorkManager
                .getInstance(this)
                .enqueue(randomNumberWorker)
        }
    }
}