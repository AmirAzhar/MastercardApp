package com.example.mastercardapp.components

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.atomic.AtomicBoolean

@RunWith(AndroidJUnit4::class)
class AppBarsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun closeTriggerCallback() {
        val wasClosed = AtomicBoolean(false)

        composeTestRule.setContent {
            AppTopBar(onClose = { wasClosed.set(true) })
        }

        composeTestRule.onNodeWithText("Close")
            .assertIsDisplayed()
            .performClick()

        assert(wasClosed.get())
    }

    @Test
    fun showChevron() {
        composeTestRule.setContent {
            AppTopBar(onClose = {}, showChevron = true)
        }

        composeTestRule.onNodeWithContentDescription("Back")
            .assertExists()
    }

    @Test
    fun hideChevron() {
        composeTestRule.setContent {
            AppTopBar(onClose = {}, showChevron = false)
        }

        composeTestRule.onAllNodesWithContentDescription("Back")
            .assertCountEquals(0)
    }

    @Test
    fun backAndNextTriggerCallback() {
        val backPressed = AtomicBoolean(false)
        val nextPressed = AtomicBoolean(false)

        composeTestRule.setContent {
            AppBottomBar(
                backLabel = "Back",
                nextLabel = "Next",
                onBack = { backPressed.set(true) },
                onNext = { nextPressed.set(true) }
            )
        }

        composeTestRule.onNodeWithText("Back")
            .assertIsDisplayed()
            .performClick()
        assert(backPressed.get())

        composeTestRule.onNodeWithText("Next")
            .assertIsDisplayed()
            .performClick()
        assert(nextPressed.get())
    }
}
