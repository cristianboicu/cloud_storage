package com.cristianboicu.cloudstorage.data.repository

import com.cristianboicu.cloudstorage.data.remote.Remote
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val remote: Remote) : Repository {
    override suspend fun register(
        username: String,
        email: String,
        password: String,
    ): Response<ResponseBody> {
        return remote.register(username, email = email, password)
    }

    override suspend fun login(email: String, password: String): Response<Unit> {
        TODO("Not yet implemented")
    }
}