package com.example.androidmasterclass.activity.module3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Lesson4MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_4_menu)
        optionsMenuEventHandler()
        popupMenuEventHandler()
        contextMenuEventHandler()
    }

    private fun optionsMenuEventHandler() {
        // get reference to button
        val btn_click_me = findViewById(R.id.simple_options_menu) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("action", "optionsMenu")
            startActivity(intent)
        }
    }

    private fun popupMenuEventHandler() {
        // get reference to button
        val btn_click_me = findViewById(R.id.popup_menu) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("action", "popupMenu")
            startActivity(intent)
        }
    }

    private fun contextMenuEventHandler() {
        // get reference to button
        val btn_click_me = findViewById(R.id.context_menu) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            intent.putExtra("action", "contextMenu")
            startActivity(intent)
        }
    }
}
