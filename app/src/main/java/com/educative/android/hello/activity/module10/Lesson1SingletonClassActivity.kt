package com.educative.android.hello.activity.module10

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.educative.android.hello.adapters.RecyclerViewAdapter
import com.example.educative.hello.R
import com.educative.android.hello.interfaces.CountryListInterface
import com.educative.android.hello.models.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Lesson1SingletonClassActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_10_lesson_1_singleton_class)
    }
}