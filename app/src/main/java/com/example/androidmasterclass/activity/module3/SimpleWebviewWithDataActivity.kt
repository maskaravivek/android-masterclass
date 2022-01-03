package com.example.androidmasterclass.activity.module3

import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class SimpleWebviewWithDataActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_webview)
        openUrl()
    }

    private fun openUrl(){
        val myWebView: WebView = findViewById(R.id.webview)

        val unencodedHtml =
            "<html><body>Webview from data example: '%23' is the percent code for ‘#‘ </body></html>";
        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
        myWebView.loadData(encodedHtml, "text/html", "base64")
    }
}
