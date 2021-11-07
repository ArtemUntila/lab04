package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

fun firstIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.fragment1)
}

fun secondIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.fragment2)
}

fun thirdIsDisplayed() {
    mainIsDisplayed()
    idIsDisplayed(R.id.fragment3)
}

fun mainIsDisplayed() = idIsDisplayed(R.id.activity_main)

fun aboutIsDisplayed() = idIsDisplayed(R.id.activity_about)

fun toFirst() = idClick(R.id.bnToFirst)

fun toSecond() = idClick(R.id.bnToSecond)

fun toThird() = idClick(R.id.bnToThird)

fun fromFirstToThird() {
    toSecond()
    toThird()
}

fun pressBackFromActionBar() {
    onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click())
}


fun idIsDisplayed(id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun idClick(id: Int) {
    onView(withId(id)).perform(click())
}
