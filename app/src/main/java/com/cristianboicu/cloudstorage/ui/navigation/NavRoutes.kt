package com.cristianboicu.cloudstorage.ui.navigation

sealed class NavRoutes(val route: String) {
    object MainScreen: NavRoutes("mainScreen")

    object SettingsScreen: NavRoutes("settingsScreen")
    object RecentScreen: NavRoutes("recentScreen")
    object TrashScreen: NavRoutes("trashScreen")
}