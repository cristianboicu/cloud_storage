package com.cristianboicu.cloudstorage.model

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
)
