package com.educative.android.hello.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class MyCustomService : Service() {
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(
            this,
            intent.extras?.get("message")?.toString() ?: "Hello world!",
            Toast.LENGTH_SHORT
        ).show()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        Toast.makeText(
            this,
            "Bye educative!",
            Toast.LENGTH_SHORT
        ).show()
        super.onDestroy()
    }
}