package com.cristianboicu.cloudstorage.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cristianboicu.cloudstorage.R
import com.cristianboicu.cloudstorage.ui.theme.CloudStorageTheme

@Composable
fun RegisterScreen(
    onBackClick: () -> Unit,
    onRegister: (username: String, email: String, password: String) -> Unit,
) {
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    CloudStorageTheme(darkTheme = false) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(painterResource(id = R.drawable.baseline_arrow_back_24), "")
                    }
                    Text(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.register),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(value = username, onValueChange = { username = it }, placeholder = {
                        Text(text = stringResource(id = R.string.username))
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(value = email, onValueChange = { email = it }, placeholder = {
                        Text(text = stringResource(id = R.string.email))
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                    TextField(value = password, onValueChange = { password = it }, placeholder = {
                        Text(text = stringResource(id = R.string.password))
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { onRegister(username, email, password) }) {
                        Text(stringResource(id = R.string.register))
                    }
                }
            }
        }
    }
}