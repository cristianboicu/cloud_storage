package com.cristianboicu.cloudstorage.ui.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cristianboicu.cloudstorage.ui.drawer.components.DrawerItem
import com.cristianboicu.cloudstorage.ui.navigation.NavRoutes
import kotlinx.coroutines.launch

@Composable
fun <T : NavRoutes> DrawerContent(
    drawerState: DrawerState,
    drawerItemsData: ArrayList<DrawerItemData<T>>,
    onClick: (T) -> Unit,
) {

    val coroutineScope = rememberCoroutineScope()
    var currentPick: T? by remember { mutableStateOf(null) }

    Surface() {
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .width(250.dp),
            horizontalAlignment = Alignment.Start
        ) {
            drawerItemsData.forEach { item ->
                DrawerItem(item) { navOption ->

                    if (currentPick == navOption) {
                        return@DrawerItem
                    }

                    currentPick = navOption

                    coroutineScope.launch {
                        drawerState.close()
                    }

                    onClick(navOption)
                }
            }
        }
    }
}