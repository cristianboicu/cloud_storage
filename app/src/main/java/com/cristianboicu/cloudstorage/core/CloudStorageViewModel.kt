package com.cristianboicu.cloudstorage.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class CloudStorageViewModel : ViewModel() {
    private val _toastMessage = MutableSharedFlow<Int>()
    val toastMessage = _toastMessage.asSharedFlow()
    fun showToastMessage(message: Int) {
        viewModelScope.launch {
            _toastMessage.emit(message)
        }
    }

    private val _navigationFlow = MutableSharedFlow<Int>()
    val navigationFlow = _navigationFlow.asSharedFlow()
    fun navigateTo(destination: Int) {
        viewModelScope.launch {
            _navigationFlow.emit(destination)
        }
    }
}