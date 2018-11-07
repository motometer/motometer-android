package ua.com.motometer.android.ui.fragment.garage

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.junit.Before
import org.junit.Test
import ua.com.motometer.android.R
import ua.com.motometer.android.ui.activity.AbstractActivityTest
import ua.com.motometer.android.ui.activity.AbstractMenuActivity
import ua.com.motometer.android.ui.activity.GarageActivity

class NewVehicleFragmentTest : AbstractActivityTest() {

    override fun activityClass(): Class<out AbstractMenuActivity> = GarageActivity::class.java

    @Before
    fun setUp() {
        onView(withId(R.id.fab))
                .perform(click())
    }

    @Test
    fun addNewVehicle() {
        onView(withId(R.id.new_vehicle_manufacturer_edit))
                .perform(typeText("Audi"))
        onView(withId(R.id.new_vehicle_model_edit))
                .perform(typeText("Q7"))
        onView(withId(R.id.new_vehicle_build_year_edit))
                .perform(typeText("2016"))
        onView(withId(R.id.new_vehicle_vin_edit))
                .perform(typeText("vvvvvvvvvvvvvvv"))
        onView(withId(R.id.new_vehicle_price_edit))
                .perform(typeText("80000"))
        onView(withId(R.id.new_vehicle_bought_date_edit))
                .perform(click())

        onView(withText("OK"))
                .perform(click())

        pressBack()

        onView(withId(R.id.button_submit)).perform(click())
        onView(withId(R.id.list)).check(matches(isCompletelyDisplayed()))
        onView(withText("Audi Q7")).check(matches(isDisplayed()))
        onView(withText("2016")).check(matches(isDisplayed()))

        onView(withText("Audi Q7")).perform(click())

        onView(withText("2016")).check(matches(isDisplayed()))
        onView(withText("vvvvvvvvvvvvvvv")).check(matches(isDisplayed()))
        onView(withText("80000")).check(matches(isDisplayed()))
    }
}