package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.compose.rally.ui.overview.OverviewBody
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

class OverviewScreenTests {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun overviewScreen_alertDisplayed(){
        composeRule.setContent {
            RallyTheme {
                OverviewBody()
            }
        }

        composeRule.onNodeWithText("Alerts").assertIsDisplayed()

    }

}