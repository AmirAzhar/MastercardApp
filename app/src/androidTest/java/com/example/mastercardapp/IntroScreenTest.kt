package com.example.mastercardapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
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
class IntroScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        ).apply {
            navigatorProvider.addNavigator(ComposeNavigator())
        }

        composeTestRule.setContent {
            AppNavigator(navController = navController)

            // nav to intro straight away
            navController.navigate(Screen.Intro.route)
        }
    }

    @Test
    fun nextSlide() {
        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithText("Choose any Mastercard™")
            .assertIsDisplayed()
    }

    @Test
    fun backToCover() {
        composeTestRule.onNodeWithText("Back").performClick()

        assertEquals(Screen.Cover.route, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun backToPrevSlide() {
        // go to slide 3
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithText("No battery —\nNo charging required")
            .assertIsDisplayed()

        // go to slide 2
        composeTestRule.onNodeWithText("Back").performClick()

        composeTestRule.onNodeWithText("Choose any Mastercard™")
            .assertIsDisplayed()

        // go to slide 1
        composeTestRule.onNodeWithText("Back").performClick()

        composeTestRule.onNodeWithText("Pay and unlock in style")
            .assertIsDisplayed()
    }


    @Test
    fun skipToTerms() {
        composeTestRule.onNodeWithText("SKIP").performClick()

        assertEquals(Screen.Terms.route, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun dotsUpdating() {
        composeTestRule.onNodeWithTag("dot_0").assertExists()
        composeTestRule.onNodeWithTag("dot_1").assertExists()
        composeTestRule.onNodeWithTag("dot_2").assertExists()

        // go next slide
        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithText("Choose any Mastercard™")
            .assertIsDisplayed()

        // go next slide
        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithText("No battery —\nNo charging required")
            .assertIsDisplayed()
    }


}
