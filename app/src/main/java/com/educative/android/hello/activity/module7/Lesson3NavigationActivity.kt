package com.educative.android.hello.activity.module7

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.educative.android.hello.fragments.module7.NavSampleFragment1Directions
import com.educative.android.hello.fragments.module7.NavSampleFragment2Directions
import com.example.educative.hello.R


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

            val action = if (navController.currentDestination?.label == "First Fragment") {
                NavSampleFragment1Directions.actionFirstFragmentToSecondFragment()
            } else {
                NavSampleFragment2Directions.actionSecondFragmentToFirstFragment()
            }

            button3.text = if (navController.currentDestination?.label == "First Fragment") {
                "Navigate to fragment 1"
            } else {
                "Navigate to fragment 2"
            }

            navController.navigate(action)
        }
    }
}