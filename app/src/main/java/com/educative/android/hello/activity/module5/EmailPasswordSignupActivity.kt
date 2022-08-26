package com.educative.android.hello.activity.module5

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.educative.hello.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class EmailPasswordSignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_email_password_auth)
        displayButtonBasedOnAction()
        auth = Firebase.auth
    }

    private fun displayButtonBasedOnAction() {
        val extras = intent.extras ?: return

        val loginSignupButton = findViewById<Button>(R.id.login_signup_button)
        val action = extras.getString("action")
        if (action.equals("login")) {
            loginSignupButton.text = getString(R.string.login)
            loginSignupButton.setOnClickListener {
                signIn()
            }
        } else if (action.equals("signup")) {
            loginSignupButton.text = getString(R.string.sign_up)
            loginSignupButton.setOnClickListener {
                createAccount()
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload();
        }
    }

    private fun createAccount() {
        val email = findViewById<EditText>(R.id.email_id)
        val password = findViewById<EditText>(R.id.password)
        auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun signIn() {
        val email = findViewById<EditText>(R.id.email_id)
        val password = findViewById<EditText>(R.id.password)
        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: FirebaseUser?) {
        val userDetailsTv = findViewById<TextView>(R.id.user_details)
        userDetailsTv.text = "Logged in as: ${user?.email}"
    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}