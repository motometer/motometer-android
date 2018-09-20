package ua.com.motometer.android.ui.activity

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ua.com.motometer.android.R

@RunWith(AndroidJUnit4::class)
class HomeActivityTest : AbstractActivityTest() {

    @Rule
    @JvmField
    var homeActivityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun shouldDisplayFab() {
        onView(withId(R.id.fab))
                .check(matches(isDisplayed()))
    }
}