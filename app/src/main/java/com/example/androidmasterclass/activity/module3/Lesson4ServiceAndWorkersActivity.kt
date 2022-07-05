package com.example.androidmasterclass.activity.module3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.androidmasterclass.R
import com.example.androidmasterclass.service.MyCustomService
import com.example.androidmasterclass.worker.GenerateRandomNumberWorker
import java.util.concurrent.TimeUnit


class Lesson4ServiceAndWorkersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_4_service_and_workers)
        attachEvents()
    }

    private fun attachEvents() {
        startService()
        stopService()
        runWorkerOnce()
    }

    private fun runWorkerOnce() {
        val button3 = findViewById<Button>(R.id.run_worker_once)
        button3.setOnClickListener {
            val randomNumberWorker: WorkRequest =
                OneTimeWorkRequestBuilder<GenerateRandomNumberWorker>()
                    .build()
            WorkManager
                .getInstance(this)
                .enqueue(randomNumberWorker)
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(randomNumberWorker.id)
                .observe(this, Observer { info ->
                    if (info != null && (info.state.isFinished)) {
                        if (info.state.name === "SUCCEEDED") {
                            val myResult = info.outputData.getInt(
                                "randomNumber",
                                0
                            )
                            Toast.makeText(
                                baseContext, "Result $myResult",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                baseContext, "Failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
        }
    }

    private fun stopService() {
        val button2 = findViewById<Button>(R.id.stop_service)
        button2.setOnClickListener {
            val intent = Intent(this, MyCustomService::class.java)
            stopService(intent)
        }
    }

    private fun startService() {
        val button1 = findViewById<Button>(R.id.start_service)
        button1.setOnClickListener {
            val intent = Intent(this, MyCustomService::class.java)
            intent.putExtra("message", "Hi Educative!")
            startService(intent)
        }
    }
}