package com.example.androidmasterclass

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        val btn_click_me = findViewById(R.id.dialog_button) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Hello World!")
                .setMessage("This is a alert dialog!")
                .show()
        }
    }
}