package com.educative.android.hello.activity.module5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.educative.hello.R
import com.facebook.drawee.backends.pipeline.Fresco
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth


class Lesson1FirebaseAuth : AppCompatActivity() {
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_module_5_lesson_1_firebase_auth)
        startEmailPasswordAuthForSignUp()
        startEmailPasswordAuthForLogin()
        startFirebaseUIActivity()
    }

    private fun startEmailPasswordAuthForSignUp() {
        val button = findViewById<Button>(R.id.email_password_auth_signup)
        button.setOnClickListener {
            val intent = Intent(this, EmailPasswordSignupActivity::class.java)
            intent.putExtra("action", "signup")
            startActivity(intent)
        }
    }

    private fun startEmailPasswordAuthForLogin() {
        val button = findViewById<Button>(R.id.email_password_auth_login)
        button.setOnClickListener {
            val intent = Intent(this, EmailPasswordSignupActivity::class.java)
            intent.putExtra("action", "login")
            startActivity(intent)
        }
    }

    private fun startFirebaseUIActivity() {
        val button = findViewById<Button>(R.id.firebase_ui_login)
        button.setOnClickListener {
            createSignInIntent()
        }
    }

    private fun createSignInIntent() {
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build())

        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        if (result.resultCode == RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            Toast.makeText(
                this, "Logged in as ${user?.email}",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                this, "Login failed",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}