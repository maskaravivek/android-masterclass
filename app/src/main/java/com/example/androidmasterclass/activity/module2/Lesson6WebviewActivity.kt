package com.example.androidmasterclass.activity.module2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Lesson6WebviewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson_6_webview)
        addOpenUrlInWebviewHandler()
        addLoadDataInWebviewHandler()
        loadUrlInDarkModeHandler()
    }

    private fun addOpenUrlInWebviewHandler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.load_url_in_webview)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            val intent = Intent(this, SimpleWebviewDemoActivity::class.java)
            intent.putExtra("action", "loadUrl")
            startActivity(intent)
        }
    }

    private fun addLoadDataInWebviewHandler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.load_data_in_webview)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            val intent = Intent(this, SimpleWebviewDemoActivity::class.java)
            intent.putExtra("action", "loadData")
            startActivity(intent)
        }
    }

    private fun loadUrlInDarkModeHandler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.load_url_in_dark_mode)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            val intent = Intent(this, SimpleWebviewDemoActivity::class.java)
            intent.putExtra("action", "darkMode")
            startActivity(intent)
        }
    }
}
