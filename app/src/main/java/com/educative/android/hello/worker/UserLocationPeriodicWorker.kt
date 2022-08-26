package com.educative.android.hello.worker

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class UserLocationPeriodicWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(
        appContext,
        workerParams
    ) {

    private var fusedLocationClient: FusedLocationProviderClient

    init {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(appContext)
    }

    override fun doWork(): Result {
        if(ActivityCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationClient.lastLocation.addOnSuccessListener {
                Log.d("UserLocationPeriodicWorker", "User location fetched")
            }
            return Result.success()
        }
        return Result.failure()
    }
}