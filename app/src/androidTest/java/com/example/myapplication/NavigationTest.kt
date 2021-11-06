package com.example.myapplication

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @Test
    fun testAbout() {
        launchActivity<MainActivity>()
        openAbout()
        idIsDisplayed(R.id.activity_about)

        pressBack()
        idIsDisplayed(R.id.activity_main)
    }

    lateinit var scenario: ActivityScenario<MainActivity>

    @Test
    fun testBackStack() {
        scenario = launchActivity()

        //First
        pressBackFromFirst()

        scenario = launchActivity()

        //Second
        toSecond()
        pressBack()
        firstIsAbsolutelyDisplayed()

        toSecond()
        toFirst()
        pressBackFromFirst()

        scenario = launchActivity()

        //Third
        toThirdDirectly()
        pressBack()
        secondIsAbsolutelyDisplayed()

        toThird()
        toSecond()
        pressBack()
        firstIsAbsolutelyDisplayed()

        toThirdDirectly()
        toFirst()
        pressBackFromFirst()
    }

    @Test
    fun testButtonsNavigation() {
        scenario = launchActivity()

        //First
        firstIsAbsolutelyDisplayed()
        toSecond()
        secondIsAbsolutelyDisplayed()

        //Second
        toFirst()
        firstIsAbsolutelyDisplayed()
        toThirdDirectly() //: toSecond() -> toThird()
        thirdIsAbsolutelyDisplayed()

        //Third
        toFirst()
        firstIsAbsolutelyDisplayed()
        toThirdDirectly()
        toSecond()
        secondIsAbsolutelyDisplayed()
    }

    private fun firstIsAbsolutelyDisplayed() {
        firstIsDisplayed()
        scenario.recreate()
        firstIsDisplayed()
    }

    private fun secondIsAbsolutelyDisplayed() {
        secondIsDisplayed()
        scenario.recreate()
        secondIsDisplayed()
    }

    private fun thirdIsAbsolutelyDisplayed() {
        thirdIsDisplayed()
        scenario.recreate()
        thirdIsDisplayed()
    }

    private fun pressBackFromFirst() {
        pressBackUnconditionally() // avoid Exception
        // In other cases state would be RESUMED
        assertEquals(Lifecycle.State.DESTROYED, scenario.state)
    }
}