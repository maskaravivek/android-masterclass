package com.educative.android.hello.activity.module7

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.educative.android.hello.worker.UserLocationPeriodicWorker
import com.educative.android.hello.worker.GenerateRandomNumberWorker
import java.util.concurrent.TimeUnit
import com.example.educative.hello.R

class Lesson1WorkManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_7_lesson_1_workmanager)
        runWorkerWithDelay()
        runWorkerPeriodically()
    }

    private fun runWorkerWithDelay() {
        val button3 = findViewById<Button>(R.id.run_worker_with_delay)
        button3.setOnClickListener {
            val randomNumberWorker: WorkRequest =
                OneTimeWorkRequestBuilder<GenerateRandomNumberWorker>()
                    .setInitialDelay(15, TimeUnit.SECONDS)
                    .build()
            WorkManager
                .getInstance(this)
                .enqueue(randomNumberWorker)
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(randomNumberWorker.id)
                .observe(this, Observer { info ->
                    var workerOutputTv = findViewById<TextView>(R.id.worker_output)
                    if (info != null && (info.state.isFinished)) {
                        if (info.state.name === "SUCCEEDED") {
                            val myResult = info.outputData.getInt(
                                "randomNumber",
                                0
                            )

                            workerOutputTv.text = "Result $myResult"
                        } else {
                            workerOutputTv.text = "Worker generated number 750. Task marked as failed"
                        }
                    }
                })
        }
    }

    private fun runWorkerPeriodically() {
        val button3 = findViewById<Button>(R.id.run_worker_periodically)
        button3.setOnClickListener {
            val randomNumberWorker: PeriodicWorkRequest = PeriodicWorkRequest
                .Builder(UserLocationPeriodicWorker::class.java, 15, TimeUnit.MINUTES)
                .setInitialDelay(1, TimeUnit.MINUTES)
                .build();
            WorkManager
                .getInstance(this)
                .enqueue(randomNumberWorker)
        }
    }
}