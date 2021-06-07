package com.bangkit.academy.wastemanagement.core.di

import com.bangkit.academy.wastemanagement.core.data.repository.WasteRepository
import com.bangkit.academy.wastemanagement.core.data.source.local.LocalDataSource
import com.bangkit.academy.wastemanagement.core.data.source.remote.RemoteDataSource
import com.bangkit.academy.wastemanagement.core.domain.repository.IWasteRepository
import com.bangkit.academy.wastemanagement.core.utils.ContentMapper
import com.bangkit.academy.wastemanagement.core.utils.WasteMapper
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
        contentMapper: ContentMapper,
        wasteMapper: WasteMapper
    ): IWasteRepository =  WasteRepository(localDataSource, remoteDataSource, contentMapper, wasteMapper)
}