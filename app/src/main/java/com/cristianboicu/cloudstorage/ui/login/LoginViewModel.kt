package com.cristianboicu.cloudstorage.ui.login

import androidx.lifecycle.ViewModel
import com.cristianboicu.cloudstorage.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val repository: Repository) : ViewModel() {
}