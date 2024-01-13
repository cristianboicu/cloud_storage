package com.cristianboicu.cloudstorage.di

import com.cristianboicu.cloudstorage.data.remote.Remote
import com.cristianboicu.cloudstorage.data.remote.RemoteImpl
import com.cristianboicu.cloudstorage.data.repository.Repository
import com.cristianboicu.cloudstorage.data.repository.RepositoryImpl
import com.cristianboicu.cloudstorage.data.service.ServiceApi
import com.cristianboicu.cloudstorage.data.service.ServiceClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideServiceApi(): ServiceApi = ServiceClient.getClient()

    @Singleton
    @Provides
    fun provideRemote(serviceApi: ServiceApi): Remote = RemoteImpl(serviceApi)

    @Singleton
    @Provides
    fun provideRepository(remote: Remote): Repository = RepositoryImpl(remote)

}