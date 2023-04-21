package com.cristianboicu.cloudstorage.ui.drawer.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cristianboicu.cloudstorage.ui.drawer.DrawerItemData

@Composable
fun <T> DrawerItem(drawerItemData: DrawerItemData<T>, onClick: (option: T) -> Unit) {

    Row(
        Modifier
            .clickable {
                onClick(drawerItemData.drawerOption)
            }, verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = drawerItemData.drawableId),
            contentDescription = stringResource(
                id = drawerItemData.descriptionId
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = stringResource(id = drawerItemData.title))
    }
    Spacer(modifier = Modifier.height(16.dp))

}