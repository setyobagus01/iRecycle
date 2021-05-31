package com.bangkit.academy.wastemanagement.data.source.remote

import com.bangkit.academy.wastemanagement.data.source.remote.retrofit.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val wasteService: ApiService){
//    suspend fun getAllWaste(): Flow<>
}