package com.idcoding.hcitest

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.idcoding.hcitest.ui.MainActivity
import com.idcoding.hcitest.ui.adapter.MainPageAdapter
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityMainTest{

    @JvmField
    @Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun displayMainActivity(){
        Espresso.onView(ViewMatchers.withId(R.id.progress_bar)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Thread.sleep(5_000)
        Espresso.onView(ViewMatchers.withId(R.id.rvProduct)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        val recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.rvProduct)
        val itemSize = recyclerView.adapter?.itemCount?.minus(1)

        Espresso.onView(ViewMatchers.withId(R.id.rvProduct))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(activityRule.activity.window.decorView)))
            .perform(itemSize?.let { RecyclerViewActions.scrollToPosition<MainPageAdapter.ListViewHolder>(it) })

        Espresso.onView(ViewMatchers.withId(R.id.rvProduct))
            .inRoot(RootMatchers.withDecorView(Matchers.`is`(activityRule.activity.window.decorView)))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MainPageAdapter.GridViewHolder>(0, click()))

    }


}