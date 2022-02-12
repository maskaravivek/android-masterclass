package com.example.androidmasterclass.activity.module6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.example.androidmasterclass.models.User
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*


class Lesson2FirebaseRealtimeDatabase : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_module_6_lesson_2_realtime_database)
        database = Firebase.database.reference
        writeTestData()
        readTestData()
    }

    private fun writeTestData() {
        val button = findViewById<Button>(R.id.write_data)
        button.setOnClickListener {
            userId = UUID.randomUUID().toString()
            writeNewUser(userId, "Educative", "support@educative.io")
        }
    }

    private fun readTestData() {
        val button = findViewById<Button>(R.id.read_data)
        button.setOnClickListener {
            readUserData(userId)
        }
    }

    private fun readUserData(userId: String) {
        database.child("users").child(userId).get().addOnSuccessListener {
            Toast.makeText(
                this, "Logged in as ${it.value}",
                Toast.LENGTH_LONG
            ).show()
        }.addOnFailureListener {
            Toast.makeText(
                this, "Error occurred",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email)
        database.child("users").child(userId).setValue(user)
        Toast.makeText(
            this, "Data added for userId: $userId",
            Toast.LENGTH_LONG
        ).show()
    }
}