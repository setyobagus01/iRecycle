package com.bangkit.academy.wastemanagement.di

import com.bangkit.academy.wastemanagement.data.source.repository.WasteRepository
import com.bangkit.academy.wastemanagement.data.source.local.LocalDataSource
import com.bangkit.academy.wastemanagement.data.source.local.room.WasteDao
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
        wasteDao: WasteDao,
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): WasteRepository =  WasteRepository(wasteDao, localDataSource, remoteDataSource)
}