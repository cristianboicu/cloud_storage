package com.cristianboicu.cloudstorage.data.remote

import com.cristianboicu.cloudstorage.model.login.LoginRequest
import com.cristianboicu.cloudstorage.model.login.LoginResponse
import com.cristianboicu.cloudstorage.model.register.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Response

interface Remote {
    suspend fun register(registerRequest: RegisterRequest): Response<ResponseBody>
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse>
}