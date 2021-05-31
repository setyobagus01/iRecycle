package com.bangkit.academy.wastemanagement.di

import com.bangkit.academy.wastemanagement.data.repository.WasteRepository
import com.bangkit.academy.wastemanagement.data.source.local.LocalDataSource
import com.bangkit.academy.wastemanagement.data.source.local.CacheMapper
import com.bangkit.academy.wastemanagement.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
        cacheMapper: CacheMapper
    ): WasteRepository =  WasteRepository(localDataSource, remoteDataSource, cacheMapper)
}