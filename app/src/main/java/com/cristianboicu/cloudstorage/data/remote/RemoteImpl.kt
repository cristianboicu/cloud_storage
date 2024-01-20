package com.cristianboicu.cloudstorage.data.remote

import com.cristianboicu.cloudstorage.data.service.ServiceApi
import com.cristianboicu.cloudstorage.model.login.LoginRequest
import com.cristianboicu.cloudstorage.model.login.LoginResponse
import com.cristianboicu.cloudstorage.model.register.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RemoteImpl @Inject constructor(private val serviceApi: ServiceApi) : Remote {
    override suspend fun register(
        registerRequest: RegisterRequest,
    ): Response<ResponseBody> {
        return serviceApi.register(registerRequest)
    }

    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return serviceApi.login(loginRequest)
    }
}