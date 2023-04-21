package com.cristianboicu.cloudstorage.ui.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cristianboicu.cloudstorage.ui.screens.MainScreen
import com.cristianboicu.cloudstorage.ui.screens.SettingsScreen
import com.cristianboicu.cloudstorage.ui.screens.recent.RecentScreen
import com.cristianboicu.cloudstorage.ui.screens.trash.TrashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    drawerState: DrawerState,
) {

    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavRoutes.MainScreen.route) {
            MainScreen(navController, drawerState)
        }
        composable(NavRoutes.SettingsScreen.route) {
            SettingsScreen()
        }
        composable(NavRoutes.RecentScreen.route) {
            RecentScreen()
        }
        composable(NavRoutes.TrashScreen.route) {
            TrashScreen()
        }
    }

}