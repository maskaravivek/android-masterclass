package com.example.androidmasterclass.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.*

class GenerateRandomNumberWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val r = Random()
        val nextNum = r.nextInt(1100)
        return when {
            nextNum <= 750 -> {
                Result.success()
            }
            nextNum <= 1000 -> {
                Result.retry()
            }
            else -> {
                Result.failure()
            }
        }
    }
}