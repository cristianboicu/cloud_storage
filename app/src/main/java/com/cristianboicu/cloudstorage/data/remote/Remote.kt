package com.cristianboicu.cloudstorage.data.remote

import okhttp3.ResponseBody
import retrofit2.Response

interface Remote {
    suspend fun register(username: String, email: String, password: String): Response<ResponseBody>
    suspend fun login(email: String, password: String): Response<Unit>
}