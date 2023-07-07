package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasContentDescriptionExactly
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChild
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest(){

        val allScreens = RallyScreen.values().toList()

        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreens,
                    onTabSelected = {},
                    currentScreen = RallyScreen.Accounts
                )
            }
        }

        //composeTestRule.onNodeWithContentDescription(RallyScreen.Accounts.name).assertIsSelected()
        //composeTestRule.onNodeWithContentDescription(RallyScreen.Accounts.name).assertExists()
        composeTestRule.onNode(hasContentDescription(RallyScreen.Accounts.name) and hasAnyChild(
            hasText(RallyScreen.Accounts.name.uppercase())), useUnmergedTree = true).assertExists()
    }
}