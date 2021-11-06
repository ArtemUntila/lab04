package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

fun firstIsDisplayed() = idIsDisplayed(R.id.fragment1)

fun secondIsDisplayed() = idIsDisplayed(R.id.fragment2)

fun thirdIsDisplayed() = idIsDisplayed(R.id.fragment3)

fun toFirst() = idClick(R.id.bnToFirst)

fun toSecond() = idClick(R.id.bnToSecond)

fun toThird() = idClick(R.id.bnToThird)

fun toThirdDirectly() {
    toSecond()
    toThird()
}

fun idIsDisplayed(id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun idClick(id: Int) {
    onView(withId(id)).perform(click())
}
