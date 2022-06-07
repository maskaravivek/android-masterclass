package com.example.androidmasterclass.activity.module3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R


class Lesson1IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3_lesson1_intents)
        attachEvents()
    }

    private fun attachEvents() {
        val button = findViewById<Button>(R.id.explicit_intent)
        button.setOnClickListener {
            val myIntent = Intent(this, ExampleSecondActivity::class.java)
            myIntent.putExtra("key", "value") //Optional parameters
            this.startActivity(myIntent)
        }

        val shareButton = findViewById<Button>(R.id.implicit_intent)
        shareButton.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "I love Educative! Find courses on https://educative.com"
            )
            shareIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                "Educative"
            )
            shareIntent.type = "text/plain"
            startActivity(shareIntent)
        }

        val sendButton = findViewById<Button>(R.id.implicit_intent_receive)
        sendButton.setOnClickListener {
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(
                Intent.EXTRA_TEXT,
                "I love Educative! Find courses on https://educative.com"
            )
            shareIntent.type = "text/plain"
            startActivity(shareIntent)
        }
    }
}