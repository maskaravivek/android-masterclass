package com.example.androidmasterclass.activity.module3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Lesson3ImagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_3_images)
        showSimpleImageEventHandler()
        showImageFromUrlEventHandler()
    }

    private fun showSimpleImageEventHandler() {
        // get reference to button
        val btn_click_me = findViewById(R.id.show_simple_image) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            val intent = Intent(this, ImagesActivity::class.java)
            intent.putExtra("action", "simpleImage")
            startActivity(intent)
        }
    }

    private fun showImageFromUrlEventHandler() {
        // get reference to button
        val btn_click_me = findViewById(R.id.show_internet_image) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            val intent = Intent(this, ImagesActivity::class.java)
            intent.putExtra("action", "imageFromUrl")
            startActivity(intent)
        }
    }
}
