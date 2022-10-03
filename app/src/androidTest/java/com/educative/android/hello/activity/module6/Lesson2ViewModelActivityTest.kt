package com.educative.android.hello.activity.module6

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.junit.Rule
import org.junit.Test
import com.example.educative.hello.R
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class Lesson2ViewModelActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(Lesson2ViewModelActivity::class.java)

    @Test
    fun incrementCounterTest() {
        onView(withId(R.id.increment)).perform(click())
        Thread.sleep(250);
        onView(withText("1")).check(matches(isDisplayed()))
    }

    @Test
    fun multipleIncrementCounterTest() {
        onView(withId(R.id.increment))
            .perform(click())
            .perform(click())
            .perform(click())
        Thread.sleep(250);
        onView(withText("3")).check(matches(isDisplayed()))
    }

    @Test
    fun decrementCounterTest() {
        onView(withId(R.id.decrement))
            .perform(click())
        Thread.sleep(250);
        onView(withText("-1")).check(matches(isDisplayed()))
    }

    @Test
    fun incrementDecrementCounterTest() {
        onView(withId(R.id.increment))
            .perform(click())
            .perform(click())
            .perform(click())

        onView(withId(R.id.decrement))
            .perform(click())
        Thread.sleep(250);
        onView(withText("2")).check(matches(isDisplayed()))
    }
}