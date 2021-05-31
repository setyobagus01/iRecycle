package com.bangkit.academy.wastemanagement.data

import com.bangkit.academy.wastemanagement.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<DataState<ResultType>> = flow {
        emit(DataState.Loading)
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(DataState.Loading)
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { DataState.Success(it) })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { DataState.Success(it) })
                }
                is ApiResponse.Error -> {
                    emit(DataState.Error(apiResponse.exception))
                }
            }
        }
    }

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<DataState<ResultType>> = result
}