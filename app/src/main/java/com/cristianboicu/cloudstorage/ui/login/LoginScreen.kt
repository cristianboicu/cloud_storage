package com.cristianboicu.cloudstorage.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.cristianboicu.cloudstorage.R
import com.cristianboicu.cloudstorage.ui.theme.CloudStorageTheme

@Composable
fun LoginScreen(
    onLogin: (username: String, password: String) -> Unit,
    onRegister: () -> Unit,
) {
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
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(value = email, onValueChange = { email = it })
                Spacer(modifier = Modifier.height(8.dp))
                TextField(value = password, onValueChange = { password = it })
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { onLogin(email, password) }) {
                    Text(stringResource(id = R.string.login))
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text("Don't have an account? Create one here.", modifier = Modifier.clickable {
                    onRegister()
                })
            }
        }
    }
}