package com.cristianboicu.cloudstorage.model

sealed class ServerResponse<T> {
    data class Success<T>(val data: T) : ServerResponse<T>()
    data class Error<T>(
        val message: String,
        val code: Int,
    ) : ServerResponse<T>()
}