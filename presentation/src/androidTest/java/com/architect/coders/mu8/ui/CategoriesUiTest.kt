package com.architect.coders.mu8.ui

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.architect.coders.mu8.R
import com.architect.coders.mu8.categories.CategoriesActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class CategoriesUiTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(CategoriesActivity::class.java, false, false)

    @Before
    fun setUp() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val intent = Intent(instrumentation.targetContext, CategoriesActivity::class.java)
        activityTestRule.launchActivity(intent)
    }

    @Test
    fun tapOnCharactersCardLaunchesCharactersActivity() {
        // Act
        onView(withId(R.id.marvel_list)).perform(actionOnItemAtPosition<ViewHolder>(FIRST_INDEX, ViewActions.click()))

        // Assert
        onView(withId(R.id.toolbar_title)).check(matches(withText(activityTestRule.activity.getString(R.string.characters_name))))
    }

    @Test
    fun tapOnComicsCardLaunchesCharactersActivity() {
        // Act
        onView(withId(R.id.marvel_list)).perform(actionOnItemAtPosition<ViewHolder>(SECOND_INDEX, ViewActions.click()))

        // Assert
        onView(withId(R.id.toolbar_title)).check(matches(withText(activityTestRule.activity.getString(R.string.comics_name))))
    }

    @Test
    fun tapOnEventsCardLaunchesCharactersActivity() {
        // Act
        onView(withId(R.id.marvel_list)).perform(actionOnItemAtPosition<ViewHolder>(THIRD_INDEX, ViewActions.click()))

        // Assert
        onView(withId(R.id.toolbar_title)).check(matches(withText(activityTestRule.activity.getString(R.string.events_name))))
    }

    companion object {
        private const val FIRST_INDEX = 0
        private const val SECOND_INDEX = 1
        private const val THIRD_INDEX = 2
    }
}
