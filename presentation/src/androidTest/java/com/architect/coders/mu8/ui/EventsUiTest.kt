package com.architect.coders.mu8.ui

import android.content.Intent
import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.architect.coders.mu8.R
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.di.DaggerUiTestComponent
import com.architect.coders.mu8.events.EventsActivity
import com.architect.coders.mu8.mock.mockedEventsResponse
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class EventsUiTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(EventsActivity::class.java, false, false)

    private lateinit var mockWebServer: MockWebServer
    private lateinit var resource: OkHttp3IdlingResource

    @Before
    fun setUp() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as DataApp
        val component = DaggerUiTestComponent.factory().create(app)

        mockWebServer = component.mockWebServer

        resource = OkHttp3IdlingResource.create("OkHttp", component.manager.okHttpClient)
        IdlingRegistry.getInstance().register(resource)

        val intent = Intent(instrumentation.targetContext, EventsActivity::class.java)
        activityTestRule.launchActivity(intent)
    }

    @Test
    fun tapOnComicNavigatesToDetail() {
        // Arrange
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(mockedEventsResponse))
        SystemClock.sleep(1000)

        // Act
        onView(withId(R.id.recycler)).perform(actionOnItemAtPosition<ViewHolder>(0, ViewActions.click()))

        // Assert
        onView(withText("Acts of Vengeance!"))
            .inRoot(withDecorView(not(`is`(activityTestRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        mockWebServer.close()
        mockWebServer.shutdown()
        IdlingRegistry.getInstance().unregister(resource)
    }
}