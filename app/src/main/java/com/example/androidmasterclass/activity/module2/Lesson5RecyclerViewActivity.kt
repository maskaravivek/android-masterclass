package com.example.androidmasterclass.activity.module2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidmasterclass.R

class Lesson5RecyclerViewActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_2_lesson_5_recycler_view)
        showSimpleRecyclerViewHandler()
    }

    private fun showSimpleRecyclerViewHandler(){
        // get reference to button
        val btn_click_me=findViewById(R.id.simple_recycler_view)as Button
        // set on-click listener
        btn_click_me.setOnClickListener{
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }
}
