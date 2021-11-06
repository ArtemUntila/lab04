package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentContentTest {

    @get: Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    // Functions are separated to detect, which Fragment has invalid content
    @Test
    fun firstContentTest() {
        activity.scenario.onActivity {
            assertNotNull(it.findViewById(R.id.bnToSecond))
            assertNull(it.findViewById(R.id.bnToFirst))
            assertNull(it.findViewById(R.id.bnToThird))
        }
    }

    @Test
    fun secondContentTest() {
        toSecond()
        activity.scenario.onActivity {
            assertNotNull(it.findViewById(R.id.bnToFirst))
            assertNotNull(it.findViewById(R.id.bnToThird))
            assertNull(it.findViewById(R.id.bnToSecond))
        }
    }

    @Test
    fun thirdContentTest() {
        toThirdDirectly()
        activity.scenario.onActivity {
            assertNotNull(it.findViewById(R.id.bnToFirst))
            assertNotNull(it.findViewById(R.id.bnToSecond))
            assertNull(it.findViewById(R.id.bnToThird))
        }
    }
}