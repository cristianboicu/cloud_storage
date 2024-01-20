package com.cristianboicu.cloudstorage.data.remote

import com.cristianboicu.cloudstorage.data.service.ServiceApi
import com.cristianboicu.cloudstorage.model.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RemoteImpl @Inject constructor(private val serviceApi: ServiceApi) : Remote {
    override suspend fun register(
        username: String,
        email: String,
        password: String,
    ): Response<ResponseBody> {
        return serviceApi.register(RegisterRequest(username, email, password))
    }

    override suspend fun login(email: String, password: String): Response<Unit> {
        TODO("Not yet implemented")
    }
}