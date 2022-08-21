package com.example.androidmasterclass.worker

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.util.*

class GenerateRandomNumberPeriodicWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {
        val r = Random()
        val nextNum = r.nextInt(1100)
        val output: Data = workDataOf("randomNumber" to nextNum)
        Log.d("GenerateRandomNumberPeriodicWorker", "Output is: $nextNum");
        return Result.success(output)
    }
}