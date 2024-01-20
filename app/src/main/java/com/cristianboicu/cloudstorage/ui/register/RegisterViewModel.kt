package com.cristianboicu.cloudstorage.ui.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristianboicu.cloudstorage.data.repository.Repository
import com.cristianboicu.cloudstorage.model.register.RegisterRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun register(username: String, email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.register(RegisterRequest(username, email, password))
                if (response.isSuccessful) {
                    Log.d("mydev", "Success: ${response.body()?.string()}")
                } else {
                    Log.d("mydev", "Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.d("mydev", "${e.message}")
            }
        }
    }
}