package ua.com.motometer.android.ui.activity

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ua.com.motometer.android.R

@RunWith(AndroidJUnit4::class)
class GarageActivityTest : AbstractActivityTest() {
    @Rule
    @JvmField
    var homeActivityRule = ActivityTestRule(GarageActivity::class.java)

    @Test
    fun shouldLoadVehicles() {
        Espresso.onView(ViewMatchers.withId(R.id.garage_list))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
