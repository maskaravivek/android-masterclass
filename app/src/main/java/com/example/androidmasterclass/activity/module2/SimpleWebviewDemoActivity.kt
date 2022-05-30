package com.example.androidmasterclass.activity.module2

import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebSettingsCompat.FORCE_DARK_ON
import androidx.webkit.WebViewFeature
import com.example.androidmasterclass.R

class SimpleWebviewDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_webview)
        displayWebviewBasedOnAction()
    }

    private fun displayWebviewBasedOnAction() {
        val extras = intent.extras
        if (extras == null) {
            openUrl(false)
        }
        val action = extras?.getString("action")
        if (action.equals("loadUrl")) {
            openUrl(false)
        } else if (action.equals("loadData")) {
            loadData()
        } else if (action.equals("darkMode")) {
            openUrl(true)
        }
    }

    private fun openUrl(forceDarkMode: Boolean) {
        val myWebView: WebView = findViewById(R.id.webview)

        if(forceDarkMode) {
            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(myWebView.settings, FORCE_DARK_ON)
            }
        }

        myWebView.settings.javaScriptEnabled = true
        myWebView.loadUrl("https://www.educative.io/")
    }

    private fun loadData() {
        val myWebView: WebView = findViewById(R.id.webview)

        val unencodedHtml =
            "<html><body>Webview from data example: '%23' is the percent code for ‘#‘ </body></html>";
        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
        myWebView.loadData(encodedHtml, "text/html", "base64")
    }
}
