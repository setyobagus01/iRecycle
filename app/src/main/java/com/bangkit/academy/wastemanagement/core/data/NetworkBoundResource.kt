package com.bangkit.academy.wastemanagement.core.data

import com.bangkit.academy.wastemanagement.core.data.source.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {
    private var result: Flow<DataState<ResultType>> = flow {
        emit(DataState.Loading())
        val dbSource = loadFromDB().firstOrNull()
        if (shouldFetch(dbSource)) {
            emit(DataState.Loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { DataState.Success(it) })
                }
                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map {
                        DataState.Success(it)
                    })
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(DataState.Error<ResultType>(apiResponse.exception))
                }
            }
        } else {
            emitAll(loadFromDB().map { DataState.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<DataState<ResultType>> = result
}