package ua.com.motometer.android.ui.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import ua.com.motometer.android.R

class HomeActivityTest : AbstractActivityTest() {

    override fun activityClass(): Class<out AbstractMenuActivity> = HomeActivity::class.java

    @Test
    fun shouldDisplayFab() {
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldOpenRecordTypeDialog() {
        onView(withId(R.id.fab)).perform(click())

        onView(withText(R.string.vehicle_choice)).check(matches(isDisplayed()))

        pressBack()
    }
}