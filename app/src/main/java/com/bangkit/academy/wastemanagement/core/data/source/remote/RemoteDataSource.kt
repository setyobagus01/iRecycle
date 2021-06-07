package com.bangkit.academy.wastemanagement.core.data.source.remote

import android.util.Log
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.ApiResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.ContentResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.WasteResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val wasteService: ApiService){
    suspend fun getWaste(): Flow<ApiResponse<List<WasteResponse>>> {
        return flow {
            try {
                val response = wasteService.getWaste()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getContent(): Flow<ApiResponse<List<ContentResponse>>> {
        return flow {
            try {
                val response = wasteService.getContent()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}