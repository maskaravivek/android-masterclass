package com.example.androidmasterclass.activity.module3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.androidmasterclass.R


class Lesson2BroadcastReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_2_broadcast_reciver)
        attachEvents()
        registerReceivers()
    }

    private fun registerReceivers() {
        val filter = IntentFilter("com.example.androidmasterclass").apply {
            addAction("com.example.androidmasterclass.NEW_VIDEO_AVAILABLE")
        }

        registerReceiver(broadcastReceiver, filter)

        LocalBroadcastManager
            .getInstance(this)
            .registerReceiver(
                broadcastReceiver,
                IntentFilter("LOCAL_NEW_VIDEO_AVAILABLE")
            )
    }

    private fun attachEvents() {
        val button1 = findViewById<Button>(R.id.send_broadcast)
        button1.setOnClickListener {
            Intent().also { intent ->
                intent.action = "com.example.androidmasterclass.NEW_VIDEO_AVAILABLE"
                intent.putExtra("broadcastType", "GENERAL")
                intent.putExtra("videoUrl", "https://example.com/video/test.mp4")
                intent.putExtra("videoTitle", "Android Masterclass Module!")
                sendBroadcast(intent)
            }
        }

        val button2 = findViewById<Button>(R.id.send_local_broadcast)
        button2.setOnClickListener {
            Intent().also {
                val intent = Intent("LOCAL_NEW_VIDEO_AVAILABLE")
                intent.putExtra("broadcastType", "LOCAL")
                intent.putExtra("videoUrl", "https://example.com/video/test.mp4")
                intent.putExtra("videoTitle", "Android Masterclass Module!")
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            }
        }
    }

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            val videoUrl = intent.getStringExtra("videoUrl")
            val videoUrlTextView = findViewById<TextView>(R.id.message)
            videoUrlTextView.text = videoUrl

            val title = intent.getStringExtra("videoTitle")
            val videoTitleTextView = findViewById<TextView>(R.id.title)
            videoTitleTextView.text = title

            val broadcastType = intent.getStringExtra("broadcastType")
            val broadcastTypeTextView = findViewById<TextView>(R.id.broadcast_type)
            broadcastTypeTextView.text = "Broadcast type: $broadcastType"
        }
    }

    override fun onDestroy() {
        LocalBroadcastManager
            .getInstance(this)
            .unregisterReceiver(broadcastReceiver)
        super.onDestroy()
    }
}