package ua.com.motometer.android.ui.activity

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withContentDescription
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ua.com.motometer.android.R

@RunWith(AndroidJUnit4::class)
abstract class AbstractActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(activityClass())

    abstract fun activityClass() : Class<out AbstractMenuActivity>

    @Test
    fun shouldOpenMenu() {
        assertThat(activityRule.activity.userFacade).isNotNull

        onView(withContentDescription(R.string.navigation_drawer_open))
                .perform(click())

        onView(withId(R.id.nav_header_title))
                .check(matches(withText("Viacheslav Bychkovskyi")))
        onView(withId(R.id.nav_header_email))
                .check(matches(withText("motometerua@gmail.com")))
        onView(withId(R.id.nav_view))
                .check(matches(isDisplayed()))

        Espresso.pressBack()

        onView(withId(R.id.nav_view))
                .check(matches(not(isDisplayed())))
    }
}