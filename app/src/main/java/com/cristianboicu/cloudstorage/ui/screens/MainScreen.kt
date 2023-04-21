package com.cristianboicu.cloudstorage.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navHostController: NavHostController,
    drawerState: DrawerState,
) {
    Scaffold(
        topBar = {
            // to run the animation independently
            val coroutineScope = rememberCoroutineScope()
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }) {
                        Icon(
                            Icons.Rounded.Menu,
                            contentDescription = "MenuButton"
                        )
                    }
                },
            )
        }
    ) {}

}
