package com.cristianboicu.cloudstorage.data.repository

import com.cristianboicu.cloudstorage.data.remote.Remote
import com.cristianboicu.cloudstorage.model.login.LoginRequest
import com.cristianboicu.cloudstorage.model.login.LoginResponse
import com.cristianboicu.cloudstorage.model.register.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val remote: Remote) : Repository {

    override suspend fun register(registerRequest: RegisterRequest): Response<ResponseBody> {
        return remote.register(registerRequest)
    }

    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return remote.login(loginRequest)
    }
}