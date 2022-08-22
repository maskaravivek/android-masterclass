package com.example.androidmasterclass.activity.module7

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.androidmasterclass.R
import com.example.androidmasterclass.fragments.module7.NavSampleFragment1Directions


class Lesson3NavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_7_lesson_3_navigation_controller)
        navigateToFragment2()
    }

    private fun navigateToFragment2() {
        val button3 = findViewById<Button>(R.id.nav_to_fragment_2)
        button3.setOnClickListener {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController

            val action =
                NavSampleFragment1Directions.actionFirstFragmentToSecondFragment()
            navController.navigate(action)
        }
    }
}