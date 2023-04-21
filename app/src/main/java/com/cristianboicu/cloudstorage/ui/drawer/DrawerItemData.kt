package com.cristianboicu.cloudstorage.ui.drawer

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class DrawerItemData<out T>(
    val drawerOption: T,
    @StringRes val title: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val descriptionId: Int
)
