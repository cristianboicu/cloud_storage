package com.cristianboicu.cloudstorage.ui.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.cristianboicu.cloudstorage.ui.drawer.DrawerContent
import com.cristianboicu.cloudstorage.ui.drawer.DrawerItemData
import com.cristianboicu.cloudstorage.ui.drawer.DrawerParams
import com.cristianboicu.cloudstorage.ui.navigation.AppNavHost
import com.cristianboicu.cloudstorage.ui.navigation.NavRoutes
import com.cristianboicu.cloudstorage.ui.theme.CloudStorageTheme

@Composable
fun MainComposable(
    navHostController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    CloudStorageTheme() {
        Surface() {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    DrawerContent(
                        drawerState = drawerState,
                        drawerItemsData = DrawerParams.drawerButtons,
                        onClick = {
                            navHostController.navigate(it.route)
                        }
                    )
                },
            ) {
                AppNavHost(
                    navController = navHostController,
                    startDestination = NavRoutes.MainScreen.route,
                    drawerState
                )
            }
        }
    }
}

