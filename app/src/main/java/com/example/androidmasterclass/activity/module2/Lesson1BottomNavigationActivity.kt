package com.example.androidmasterclass.activity.module2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.androidmasterclass.R
import com.example.androidmasterclass.fragments.BottomTabFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Lesson1BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_module_3_lesson1_bottom_nav_bar)
        //show default tab
        showBottomTabFragment("Favorites")
        attachEventHandlers()
        showBadge()
    }

    private fun showBadge() {
        val bottomNavView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        var badge = bottomNavView.getOrCreateBadge(R.id.page_4)
        badge.isVisible = true
        // An icon only badge will be displayed unless a number is set:
        badge.number = 100
        badge.maxCharacterCount = 2
    }

    private fun attachEventHandlers() {
        val bottomNavView = findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_1 -> {
                    showBottomTabFragment("Favorites")
                    true
                }
                R.id.page_2 -> {
                    showBottomTabFragment("Music")
                    true
                }
                R.id.page_3 -> {
                    showBottomTabFragment("Places")
                    true
                }
                R.id.page_4 -> {
                    showBottomTabFragment("News")
                    true
                }
                else -> false
            }
        }
    }

    private fun showBottomTabFragment(tabName: String) {
        val bundle = bundleOf("tabName" to tabName)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<BottomTabFragment>(R.id.fragment_container_view, args = bundle)
        }
    }
}