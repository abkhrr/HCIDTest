package com.idcoding.hcitest

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.idcoding.hcitest.ui.browser.BrowserApp
import com.idcoding.hcitest.utils.Const
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
*  By Adya Bukhari
*  29 February, 2020
*  Email : Bukhariadbuk@gmail.com
*/

@RunWith(AndroidJUnit4::class)
class BrowserTest{
    @JvmField
    @Rule
    var activityRule = ActivityTestRule(BrowserApp::class.java, true, false)

    @Before
    fun setup(){
        val targetContext = InstrumentationRegistry.getInstrumentation()
            .targetContext
        val intent = Intent(targetContext, BrowserApp::class.java)
        intent.putExtra("link", Const.TEST_URL)

        activityRule.launchActivity(intent)
    }

    @Test
    fun launchBrowser(){
        Espresso.onView(ViewMatchers.withId(R.id.progressBar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Thread.sleep(5_000)
        Espresso.onView(ViewMatchers.withId(R.id.webView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}