package com.example.mastercardapp

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mastercardapp.screens.Screen
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoverScreenTest {

    // you need this for every test so that you can use testing utlities
    @get:Rule
    val composeTestRule = createComposeRule()

    // simulate nav
    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {

        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        ).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
        }

        // use the app nav
        composeTestRule.setContent {
            AppNavigator(navController = navController)
        }
    }

    @Test
    fun continueToIntro() {
        // continue button visible
        composeTestRule.onNodeWithText("Continue")
            .assertIsDisplayed()

        // click button
        composeTestRule.onNodeWithText("Continue")
            .performClick()

        // navigate to intro
        assertEquals(Screen.Intro.route, navController.currentBackStackEntry?.destination?.route)
    }
}
