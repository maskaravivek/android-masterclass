package com.example.androidmasterclass.activity.module6

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import java.net.URL

class Lesson1FirebaseAuth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_module_6_lesson_1_firebase_auth)
        displayMenuBasedOnAction()
    }

    private fun displayMenuBasedOnAction() {
        val extras = intent.extras
        if (extras == null) {
            return
        }
    }
}