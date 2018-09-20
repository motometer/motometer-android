package ua.com.motometer.android.ui.activity

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import org.junit.Test
import ua.com.motometer.android.R

class GarageActivityTest : AbstractActivityTest() {

    override fun activityClass(): Class<out AbstractMenuActivity> = GarageActivity::class.java

    @Test
    fun shouldLoadVehicles() {
        Espresso.onView(ViewMatchers.withId(R.id.garage_list))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
