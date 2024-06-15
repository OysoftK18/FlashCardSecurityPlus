package com.oysoft.studyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oysoft.studyapp.ui.screens.FlashCardsScreen
import com.oysoft.studyapp.ui.screens.HomeScreen
import com.oysoft.studyapp.viewModels.FlashCardsViewModel
import com.oysoft.studyapp.viewModels.HomeScreenViewModel

sealed class Screen(val route: String) {
    object Home : Screen("HomeScreen")
    object FlashCards : Screen("FlashCardsScreen")
}

@Composable
fun NavigationManager(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
            HomeScreen(
                modifier = modifier,
                navController,
                homeScreenViewModel = homeScreenViewModel
            )
        }
        composable(Screen.FlashCards.route) {
            val flashCardsViewModel = hiltViewModel<FlashCardsViewModel>()
            FlashCardsScreen(
                modifier = modifier,
                flashCardsViewModel = flashCardsViewModel
            )
        }
    }
}