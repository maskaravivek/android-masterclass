package com.example.androidmasterclass.activity.module6

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import java.net.URL

class Lesson1FirebaseAuth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_module_6_lesson_1_firebase_auth)
        startEmailPasswordAuthForSignUp()
        startEmailPasswordAuthForLogin()
    }

    private fun startEmailPasswordAuthForSignUp() {
        val button = findViewById(R.id.email_password_auth_signup) as Button
        button.setOnClickListener {
            val intent = Intent(this, EmailPasswordSignupActivity::class.java)
            intent.putExtra("action", "signup")
            startActivity(intent)
        }
    }

    private fun startEmailPasswordAuthForLogin() {
        val button = findViewById(R.id.email_password_auth_login) as Button
        button.setOnClickListener {
            val intent = Intent(this, EmailPasswordSignupActivity::class.java)
            intent.putExtra("action", "login")
            startActivity(intent)
        }
    }
}