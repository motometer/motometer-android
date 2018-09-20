package ua.com.motometer.android.ui.activity

import android.support.test.rule.ActivityTestRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test

class LauncherActivityTest {
    @Rule
    @JvmField
    var laucherActivity = ActivityTestRule(LauncherActivity::class.java)

    @Test
    fun shouldFinishActivity() {
        assertThat(laucherActivity.activityResult.resultCode).isEqualTo(0)
    }
}