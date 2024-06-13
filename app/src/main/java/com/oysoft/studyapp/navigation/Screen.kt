package com.oysoft.studyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oysoft.studyapp.screens.FlashCardsScreen
import com.oysoft.studyapp.screens.HomeScreen
import com.oysoft.studyapp.viewModels.FlashCardsViewModel

sealed class Screen(val route: String) {
    object Home: Screen("HomeScreen")
    object FlashCards: Screen("FlashCardsScreen")
}

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(modifier = modifier, navController) }
        composable(Screen.FlashCards.route) { FlashCardsScreen(modifier = modifier, flashCardsViewModel = FlashCardsViewModel()) }
    }
}