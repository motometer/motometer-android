package ua.com.motometer.android.ui.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
import ua.com.motometer.android.R

class HomeActivityTest : AbstractActivityTest() {

    override fun activityClass(): Class<out AbstractMenuActivity> = HomeActivity::class.java

    @Test
    fun shouldDisplayFab() {
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()))

        onView(withId(R.id.record_list))
                .check(matches(isDisplayed()))
    }

    @Test
    fun newRecordViewDisplayed() {
        onView(withId(R.id.fab))
                .perform(ViewActions.click())

        onView(withId(R.id.new_record_view))
                .check(matches(isDisplayed()))
    }
}