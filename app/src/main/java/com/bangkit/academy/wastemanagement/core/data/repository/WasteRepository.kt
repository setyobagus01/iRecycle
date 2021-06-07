package com.bangkit.academy.wastemanagement.core.data.repository

import android.util.Log
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.data.NetworkBoundResource
import com.bangkit.academy.wastemanagement.core.data.source.local.LocalDataSource
import com.bangkit.academy.wastemanagement.core.data.source.remote.RemoteDataSource
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.ApiResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.WasteResponse
import com.bangkit.academy.wastemanagement.core.domain.model.Content
import com.bangkit.academy.wastemanagement.core.domain.model.Image
import com.bangkit.academy.wastemanagement.core.domain.model.Waste
import com.bangkit.academy.wastemanagement.core.domain.repository.IWasteRepository
import com.bangkit.academy.wastemanagement.core.utils.ContentMapper
import com.bangkit.academy.wastemanagement.core.utils.WasteMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

@Singleton
class WasteRepository constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val contentMapper: ContentMapper,
    private val wasteMapper: WasteMapper
): IWasteRepository {
    override fun getWaste(): Flow<DataState<List<Waste>>> =
        object : NetworkBoundResource<List<Waste>, List<WasteResponse>>() {
            override fun loadFromDB(): Flow<List<Waste>> {
                return localDataSource.getWaste().map {
                    Log.d("Log babi", it.toString())
                    wasteMapper.mapFromCacheEntityList(it) }
            }

            override fun shouldFetch(data: List<Waste>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<WasteResponse>>> =
                remoteDataSource.getWaste()


            override suspend fun saveCallResult(data: List<WasteResponse>) {
                val waste = wasteMapper.mapFromNetworkEntityList(data)
                localDataSource.insertWaste(waste)
            }

        }.asFlow()

    override fun getWasteById(id: Int): Flow<DataState<Waste>> {
        TODO("Not yet implemented")
    }

    override fun getImages(): Flow<DataState<List<Image>>> {
        TODO("Not yet implemented")
    }

    override fun getImageById(id: Int): Flow<DataState<Image>> {
        TODO("Not yet implemented")
    }

    override fun getContent(): Flow<DataState<List<Content>>> {
        TODO("Not yet implemented")
    }

    override fun getContentById(id: Int): Flow<DataState<Content>> {
        TODO("Not yet implemented")
    }

    override fun getBookmarkedContent(): Flow<List<Content>> {
        TODO("Not yet implemented")
    }

    override fun setBookmarkedContent(content: Content, state: Boolean) {
        TODO("Not yet implemented")
    }

}