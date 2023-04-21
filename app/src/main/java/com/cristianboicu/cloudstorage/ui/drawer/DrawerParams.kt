package com.cristianboicu.cloudstorage.ui.drawer

import com.cristianboicu.cloudstorage.R
import com.cristianboicu.cloudstorage.ui.navigation.NavRoutes

object DrawerParams {
    val drawerButtons = arrayListOf(
        DrawerItemData(
            NavRoutes.RecentScreen,
            R.string.drawer_recent,
            R.drawable.ic_recent,
            R.string.drawer_recent
        ),
        DrawerItemData(
            NavRoutes.TrashScreen,
            R.string.drawer_trash,
            R.drawable.ic_trash,
            R.string.drawer_trash
        ),
        DrawerItemData(
            NavRoutes.SettingsScreen,
            R.string.drawer_settings,
            R.drawable.ic_settings,
            R.string.drawer_settings
        ),
    )
}