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

    lateinit var scenario: ActivityScenario<MainActivity>

    @Test
    fun testAbout() {
        scenario = launchActivity()
        openAbout()
        idIsDisplayed(R.id.activity_about)

        pressBack()
        idIsDisplayed(R.id.activity_main)
        scenario.recreate()
        idIsDisplayed(R.id.activity_main)
        pressBackFromFirst()

        val aboutScenario = launchActivity<AboutActivity>()
        idIsDisplayed(R.id.activity_about)
        aboutScenario.recreate()
        idIsDisplayed(R.id.activity_about)
    }

    private fun aboutIsAbsolutelyDisplayed() {
        idIsDisplayed(R.id.activity_about)
        scenario.recreate()
        idIsDisplayed(R.id.activity_about)
    }

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