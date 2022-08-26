package com.educative.android.hello.activity.module3

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.educative.hello.R

class ExampleReceiveUrlActivity : AppCompatActivity() {

    companion object {
        const val TEXT_MIME_TYPE = "text/plain"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson1_receive_url)

        when (intent?.action) {
            Intent.ACTION_SEND -> {
                if (TEXT_MIME_TYPE == intent.type) {
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        openUrl(it)
                    }
                }
            }
        }
    }

    private fun openUrl(url: String) {
        val receivedUrl: EditText = findViewById(R.id.received_url)
        receivedUrl.setText(url)

        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.loadUrl(url)
    }
}