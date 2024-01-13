package com.cristianboicu.cloudstorage.data.service

import com.cristianboicu.cloudstorage.data.remote.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceApi {
    @GET("/login")
    suspend fun login(email: String, password: String): Response<Unit>

    @POST("user/register")
    suspend fun register(@Body req: RegisterRequest): Response<ResponseBody>
}