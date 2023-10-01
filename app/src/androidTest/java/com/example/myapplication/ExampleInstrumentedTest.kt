package com.example.myapplication

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapplication.R
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import android.os.IBinder
import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.not


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var activityScenario: ActivityScenario<LoginActivity>

    @Before
    fun setup() {
        // Launch the LoginActivity before each test
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = Intent(context, LoginActivity::class.java)
        activityScenario = ActivityScenario.launch(intent)
    }

    @After
    fun tearDown() {
        // Close the LoginActivity after each test
        activityScenario.close()
        Thread.sleep(1000);
    }

    @Test
    fun testValidLoginOne() {
        // Enter valid username and password
        Espresso.onView(ViewMatchers.withId(R.id.usernameField))
            .perform(ViewActions.typeText("user1"))
        Espresso.onView(ViewMatchers.withId(R.id.passwordField))
            .perform(ViewActions.typeText("password1"))
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if MainActivity is launched
        Espresso.onView(ViewMatchers.withId(R.id.textView2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testValidLoginTwo() {
        // Enter valid username and password
        Espresso.onView(ViewMatchers.withId(R.id.usernameField))
            .perform(ViewActions.typeText("user2"))
        Espresso.onView(ViewMatchers.withId(R.id.passwordField))
            .perform(ViewActions.typeText("password2"))
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if MainActivity is launched
        Espresso.onView(ViewMatchers.withId(R.id.textView2))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testInvalidLoginOne() {
        // Enter invalid username and valid password
        Espresso.onView(ViewMatchers.withId(R.id.usernameField))
            .perform(ViewActions.typeText("invalid_user"))
        Espresso.onView(ViewMatchers.withId(R.id.passwordField))
            .perform(ViewActions.typeText("password1"))
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if you are still in LoginActivity
        onView(ViewMatchers.withId(R.id.usernameField))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testInvalidLoginTwo() {
        // Enter valid username and invalid password
        Espresso.onView(ViewMatchers.withId(R.id.usernameField))
            .perform(ViewActions.typeText("user1"))
        Espresso.onView(ViewMatchers.withId(R.id.passwordField))
            .perform(ViewActions.typeText("invalid_password"))
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if you are still in LoginActivity
        onView(ViewMatchers.withId(R.id.usernameField))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }


    @Test
    fun testEmptyFields() {
        // Click the login button without entering any credentials
        Espresso.onView(ViewMatchers.withId(R.id.loginButton))
            .perform(ViewActions.click())

        // Check if you are still in LoginActivity
        onView(ViewMatchers.withId(R.id.usernameField))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
