package com.example.androidmasterclass.activity.module7

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.androidmasterclass.R
import com.example.androidmasterclass.viewmodel.CounterLifecycleObserver
import com.example.androidmasterclass.worker.GenerateRandomNumberWorker

class Lesson1WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_7_lesson_1_workmanager)
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
}