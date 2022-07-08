package com.example.androidmasterclass.activity.module5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R
import com.example.androidmasterclass.models.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*


class Lesson2FirebaseRealtimeDatabase : AppCompatActivity() {
    private lateinit var database: DatabaseReference
    private var userId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_5_lesson_2_realtime_database)

        database = Firebase.database.reference
        writeTestData()
        readTestData()
    }

    private fun writeTestData() {
        val button = findViewById<Button>(R.id.write_data)
        button.setOnClickListener {
            userId = UUID.randomUUID().toString()
            val username = findViewById<EditText>(R.id.user_name).text.toString()
            val email = findViewById<EditText>(R.id.user_email).text.toString()
            writeNewUser(userId, username, email)
        }
    }

    private fun readTestData() {
        val button = findViewById<Button>(R.id.read_data)
        button.setOnClickListener {
            readUserData(userId)
        }
    }

    private fun readUserData(userId: String) {
        database.child("users").child(userId).get()
            .addOnSuccessListener {
                val userIdTv = findViewById<TextView>(R.id.user_id_tv)
                val usernameTv = findViewById<TextView>(R.id.user_name_tv)
                val emailTv = findViewById<TextView>(R.id.user_email_tv)

                val user = it.value as HashMap<String, String>

                userIdTv.text = "ID: ${it.key}"
                usernameTv.text = "Username: ${user["username"]}"
                emailTv.text = "Email: ${user["email"]}"

            }.addOnFailureListener {
                Toast.makeText(
                    this, "Error occurred ${it.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }

    private fun updateData(userId: String, email: String) {
        val dataToUpdate = hashMapOf<String, Any>("email" to email)
        database.child("users").child(userId)
            .updateChildren(dataToUpdate)
    }

    private fun deleteData(userId: String) {
        database.child("users").child(userId).removeValue()
    }

    private fun writeNewUser(userId: String, name: String, email: String) {
        val user = User(name, email)
        database.child("users").child(userId).setValue(user).addOnSuccessListener {
            Toast.makeText(
                this, "Data added for userId: $userId",
                Toast.LENGTH_LONG
            ).show()
        }.addOnFailureListener {
            Toast.makeText(
                this, "Error occurred ${it.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}