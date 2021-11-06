package com.example.myapplication

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityContentTest {

    @Test
    fun testButtonTextChange() {
        val scenario = launchActivity<MainActivity>()
        println(scenario.state.toString())
        Espresso.pressBackUnconditionally()
        println(scenario.state.toString())
    }
}