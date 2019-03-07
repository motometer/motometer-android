package ua.com.motometer.android.ui.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
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