package com.educative.android.hello.activity.module8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.educative.hello.R
import com.educative.android.hello.database.MyDatabase
import com.educative.android.hello.database.dao.UserDao
import com.educative.android.hello.database.entity.User
import kotlinx.coroutines.launch

class Lesson5RoomDBActivity : AppCompatActivity() {

    lateinit var database: MyDatabase
    lateinit var userDao: UserDao

    private var userEmail: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_8_lesson_5_room_db_and_migration)
        database = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java, "my-database"
        ).addMigrations(MyDatabase.MIGRATION_2_3).build()
        userDao = database.userDao()
        writeTestData()
        readTestData()
    }

    private fun writeTestData() {
        val button = findViewById<Button>(R.id.write_data)
        button.setOnClickListener {
            val username = findViewById<EditText>(R.id.user_name).text.toString()
            val email = findViewById<EditText>(R.id.user_email).text.toString()
            val age = findViewById<EditText>(R.id.user_age).text.toString()
            val address = findViewById<EditText>(R.id.user_address).text.toString()
            userEmail = email
            lifecycleScope.launch {
                userDao.insert(User(id = 0, name = username, email = email, age = age.toInt(), address = address))
            }
        }
    }

    private fun readTestData() {
        val button = findViewById<Button>(R.id.read_data)
        button.setOnClickListener {
            lifecycleScope.launch {
                var user = userDao.getByEmailId(userEmail)

                val userIdTv = findViewById<TextView>(R.id.user_id_tv)
                val usernameTv = findViewById<TextView>(R.id.user_name_tv)
                val emailTv = findViewById<TextView>(R.id.user_email_tv)
                val ageTv = findViewById<TextView>(R.id.user_age_tv)
                val addressTv = findViewById<TextView>(R.id.user_address_tv)

                userIdTv.text = "ID: ${user.id}"
                usernameTv.text = "Username: ${user.name}"
                emailTv.text = "Email: ${user.email}"
                ageTv.text = "Age: ${user.age}"
                addressTv.text = "Address: NA"
            }
        }
    }
}