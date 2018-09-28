package ua.com.motometer.android.ui.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import org.junit.Test
import ua.com.motometer.android.R

class GarageActivityTest : AbstractActivityTest() {

    override fun activityClass(): Class<out AbstractMenuActivity> = GarageActivity::class.java

    @Test
    fun loadVehicles() {
        onView(withId(R.id.list))
                .check(matches(isDisplayed()))
    }

    @Test
    fun newVehicleFragmentDisplayed() {
        onView(withId(R.id.fab))
                .perform(click())

        onView(withId(R.id.new_vehicle_fragment))
                .check(matches(isDisplayed()))
    }

    @Test
    fun newVehicleFragmentClosedOnBack() {
        onView(withId(R.id.fab))
                .perform(click())

        pressBack()

        onView(withId(R.id.list))
                .check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun newVehicleFragmentClosedOnCancel() {
        onView(withId(R.id.fab))
                .perform(click())

        onView(withId(R.id.new_vehicle_cancel))
                .perform(click())


        onView(withId(R.id.list))
                .check(matches(isCompletelyDisplayed()))
    }
}
