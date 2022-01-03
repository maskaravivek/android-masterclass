package com.example.androidmasterclass.activity.module3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Lesson6WebviewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_6_webview_activity)
        addOpenUrlInWebviewHandler()
        addLoadDataInWebviewHandler()
    }

    private fun addOpenUrlInWebviewHandler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.load_url_in_webview)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            val intent = Intent(this, SimpleWebviewFromUrlActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addLoadDataInWebviewHandler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.load_data_in_webview)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            val intent = Intent(this, SimpleWebviewWithDataActivity::class.java)
            startActivity(intent)
        }
    }
}
