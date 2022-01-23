package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cleanarchitecturenoteapp.di.module.AppModule
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.MainActivity
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.util.Screen
import com.plcoding.cleanarchitecturenoteapp.ui.theme.CleanArchitectureNoteAppTheme
import com.plcoding.cleanarchitecturenoteapp.util.TestTags
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * What UninstallModules does here is to Remove the `AppModule` from the
 * Dependency Graph's
 * So that we can insert our Binding for the dependencies.
 */
@HiltAndroidTest
@UninstallModules(AppModule::class)
@ExperimentalAnimationApi
class NotesScreenKtTest {

    // Order Here specific, How it will execute
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()


    @Before
    fun setup(){
        // Used to Inject all the dependencies that we have
        // Provided excluding the AppModule here
        // Eg: Mocking the Room Database.
        hiltRule.inject()
        // We are defining our own composable contents.
        // The part that we want to start
        /** This setContent provide us the composable scope thats
         * Why we are able to access the composable functions
         */
        composeRule.setContent {
            val navController = rememberNavController()
            CleanArchitectureNoteAppTheme(){
                // Theme is important to Import and define composable inside it
                NavHost(
                    navController = navController,
                    startDestination = Screen.NotesScreen.route
                ) {
                    composable(route = Screen.NotesScreen.route) {
                        NotesScreen(navController = navController)
                    }
                }
            }
        }
    }

    @Test
    fun clickToggleOrderSection_isVisible(){
        // Currently the Sort is Collapsed Checking that
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertDoesNotExist()
        // Performing a Click Events
        composeRule.onNodeWithContentDescription("Sort").performClick()
        // Check whether if the Sort Btn Expanded or not.
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertIsDisplayed()
    }
}