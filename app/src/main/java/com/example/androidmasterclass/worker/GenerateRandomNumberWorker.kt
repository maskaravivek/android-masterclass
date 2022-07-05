package com.example.androidmasterclass.worker

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.util.*

class GenerateRandomNumberWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val r = Random()
        val nextNum = r.nextInt(1100)
        return when {
            nextNum <= 750 -> {
                val output: Data = workDataOf("randomNumber" to nextNum)
                Result.success(output)
            }

            else -> {
                Result.failure()
            }
        }
    }
}