package com.cristianboicu.cloudstorage.ui.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.cristianboicu.cloudstorage.R
import com.cristianboicu.cloudstorage.core.CloudStorageViewModel
import com.cristianboicu.cloudstorage.data.repository.Repository
import com.cristianboicu.cloudstorage.model.login.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: Repository) :
    CloudStorageViewModel() {
    fun login(emailOrUsername: String, password: String) {
        val request = LoginRequest.buildLoginRequest(emailOrUsername, password)
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.login(request)

            if (response.isSuccessful) {
                Log.d("mydev", "Success" + response.body().toString())
                navigateTo(R.id.action_loginFragment_to_homeFragment)
            } else {
                Log.d("mydev", "Error" + response.errorBody()?.bytes()?.decodeToString())
                showToastMessage(R.string.login)
            }
        }
    }
}