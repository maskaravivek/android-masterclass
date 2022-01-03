package com.example.androidmasterclass.activity.module3

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class SimpleWebviewFromUrlActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_webview)
        openUrl()
    }

    private fun openUrl(){
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl("https://www.educative.io/")
    }
}
