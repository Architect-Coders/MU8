package com.architect.coders.mu8.ui

import android.content.Intent
import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.architect.coders.mu8.R
import com.architect.coders.mu8.characters.CharactersActivity
import com.architect.coders.mu8.data.DataApp
import com.architect.coders.mu8.di.DaggerUiTestComponent
import com.architect.coders.mu8.mock.mockedCharactersResponse
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@LargeTest
class CharactersUiTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(CharactersActivity::class.java, false, false)

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

        val intent = Intent(instrumentation.targetContext, CharactersActivity::class.java)
        activityTestRule.launchActivity(intent)
    }

    @Test
    fun tapOnCharacterNavigatesToDetail() {
        // Arrange
        mockWebServer.enqueue(MockResponse().setResponseCode(200).setBody(mockedCharactersResponse))
        SystemClock.sleep(1000)

        // Act
        onView(withId(R.id.recycler)).perform(actionOnItemAtPosition<ViewHolder>(1, ViewActions.click()))

        // Assert
        onView(withId(R.id.toolbar_title)).check(matches(withText("3-D Man")))
    }

    @After
    fun tearDown() {
        mockWebServer.close()
        mockWebServer.shutdown()
        IdlingRegistry.getInstance().unregister(resource)
    }
}