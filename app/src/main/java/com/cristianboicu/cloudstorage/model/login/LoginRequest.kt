package com.cristianboicu.cloudstorage.model.login

import android.util.Patterns

data class LoginRequest(
    val username: String?,
    val email: String?,
    val password: String,
) {
    companion object {
        fun buildLoginRequest(emailOrUsername: String, password: String): LoginRequest {
            return if (Patterns.EMAIL_ADDRESS.matcher(emailOrUsername).matches()) {
                LoginRequest(
                    username = null,
                    email = emailOrUsername,
                    password = password
                )
            } else {
                LoginRequest(
                    username = emailOrUsername,
                    email = null,
                    password = password
                )
            }
        }
    }
}
