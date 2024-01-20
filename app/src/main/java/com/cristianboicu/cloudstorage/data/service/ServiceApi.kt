package com.cristianboicu.cloudstorage.data.service

import com.cristianboicu.cloudstorage.model.login.LoginRequest
import com.cristianboicu.cloudstorage.model.login.LoginResponse
import com.cristianboicu.cloudstorage.model.register.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {
    @POST("user/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("user/register")
    suspend fun register(@Body req: RegisterRequest): Response<ResponseBody>
}