package com.example.mastercardapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mastercardapp.screens.Screen
import org.junit.Assert.assertEquals
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.platform.testTag
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TermsScreenTest {

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
            // nav to terms
            navController.navigate(Screen.Terms.route)
        }
    }

    @Test
    fun agreeToCover() {
        composeTestRule.onNodeWithText("Agree").performClick()
        assertEquals(Screen.Cover.route, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun disagreeToCover() {
        composeTestRule.onNodeWithText("Disagree").performClick()
        assertEquals(Screen.Cover.route, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun termsScrollable() {
        composeTestRule.onNodeWithTag("termsScroll")
            .assert(hasScrollAction())
    }
}
