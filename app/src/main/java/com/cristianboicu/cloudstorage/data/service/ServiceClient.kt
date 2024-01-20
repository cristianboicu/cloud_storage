package com.cristianboicu.cloudstorage.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceClient {
    private const val BASE_URL = "http://eurgberuiygbw.go.ro/api/v1/"
    private var serviceClient: ServiceApi? = null

    fun getClient(): ServiceApi {
        return if (serviceClient == null) {
            serviceClient = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceApi::class.java)
            serviceClient as ServiceApi
        } else {
            serviceClient!!
        }
    }
}