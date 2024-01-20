package com.cristianboicu.cloudstorage.model.register

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String,
)
