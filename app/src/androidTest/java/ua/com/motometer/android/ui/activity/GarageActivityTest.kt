package ua.com.motometer.android.ui.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withSpinnerText
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import ua.com.motometer.android.R

class GarageActivityTest : AbstractActivityTest() {

    override fun activityClass(): Class<out AbstractMenuActivity> = GarageActivity::class.java

    @Test
    fun emptyGarage() {
        onView(withId(R.id.empty_garage))
                .check(matches(isDisplayed()))

        onView(withText(R.string.empty_garage))
                .check(matches(isDisplayed()))
    }

    @Test
    fun newVehicleFragmentDisplayed() {
        onView(withId(R.id.fab))
                .perform(click())

        onView(withId(R.id.new_vehicle_fragment))
                .check(matches(isDisplayed()))
        onView(withId(R.id.new_vehicle_type_choice))
                .check(matches(isDisplayed()))
    }

    @Test
    fun newVehicleFragmentClosedOnBack() {
        onView(withId(R.id.fab))
                .perform(click())

        pressBack()

        onView(withId(R.id.empty_garage))
                .check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun newVehicleFragmentClosedOnCancel() {
        onView(withId(R.id.fab))
                .perform(click())

        onView(withId(R.id.button_cancel))
                .perform(click())


        onView(withId(R.id.empty_garage))
                .check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun vehicleTypeSelection() {
        onView(withId(R.id.fab))
                .perform(click())

        onView(withId(R.id.new_vehicle_type_choice))
                .perform(click())

        onView(withText("Truck"))
                .perform(click())

        onView(withId(R.id.new_vehicle_type_choice))
                .check(matches(withSpinnerText("Truck")))
    }
}
