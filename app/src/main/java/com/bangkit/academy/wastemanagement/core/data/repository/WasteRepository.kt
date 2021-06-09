package com.bangkit.academy.wastemanagement.core.data.repository

import android.util.Log
import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.data.NetworkBoundResource
import com.bangkit.academy.wastemanagement.core.data.source.local.LocalDataSource
import com.bangkit.academy.wastemanagement.core.data.source.local.entity.WasteEntity
import com.bangkit.academy.wastemanagement.core.data.source.remote.RemoteDataSource
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.ApiResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.ContentResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.PredictResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.WasteResponse
import com.bangkit.academy.wastemanagement.core.domain.model.Content
import com.bangkit.academy.wastemanagement.core.domain.model.Image
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.core.domain.model.Waste
import com.bangkit.academy.wastemanagement.core.domain.repository.IWasteRepository
import com.bangkit.academy.wastemanagement.core.utils.ContentMapper
import com.bangkit.academy.wastemanagement.core.utils.PredictMapper
import com.bangkit.academy.wastemanagement.core.utils.WasteMapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Singleton

@Singleton
class WasteRepository constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val contentMapper: ContentMapper,
    private val wasteMapper: WasteMapper,
    private val predictMapper: PredictMapper
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

    override fun getWasteByType(wasteType: String): Flow<DataState<Waste>> =
        object : NetworkBoundResource<Waste, WasteEntity>() {
            override fun loadFromDB(): Flow<Waste> =
                localDataSource.getWasteByType(wasteType).map {
                    wasteMapper.mapFromCacheEntity(it)
                }

            override fun shouldFetch(data: Waste?): Boolean =
                false

            override suspend fun createCall(): Flow<ApiResponse<WasteEntity>> =
                emptyFlow()

            override suspend fun saveCallResult(data: WasteEntity) {

            }

        }.asFlow()

    override fun getPrediction(pic: File): Flow<DataState<List<Predict>>> =
        object : NetworkBoundResource<List<Predict>, List<PredictResponse>>() {
            override fun loadFromDB(): Flow<List<Predict>> =
                localDataSource.getPrediction().map { predictMapper.mapFromCacheEntityList(it) }

            override fun shouldFetch(data: List<Predict>?): Boolean =
                true


            override suspend fun createCall(): Flow<ApiResponse<List<PredictResponse>>> =
                remoteDataSource.getPrediction(pic)


            override suspend fun saveCallResult(data: List<PredictResponse>) {
                val predict = predictMapper.mapFromNetworkEntityList(data)
                localDataSource.insertPrediction(predict)
            }

        }.asFlow()

    override fun getPredictionHistory(): Flow<DataState<List<Predict>>> =
        object : NetworkBoundResource<List<Predict>, List<PredictResponse>>() {
            override fun loadFromDB(): Flow<List<Predict>> =
                localDataSource.getPredictionHistory().map { predictMapper.mapFromCacheEntityList(it) }

            override fun shouldFetch(data: List<Predict>?): Boolean =
                false

            override suspend fun createCall(): Flow<ApiResponse<List<PredictResponse>>> = emptyFlow()
            override suspend fun saveCallResult(data: List<PredictResponse>) {

            }

        }.asFlow()

    override fun setImagePrediction(prediction: Predict, imageUrl: String, history: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.updatePrediction(predictMapper.mapFromDomain(prediction), imageUrl, history)
        }
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

    override fun getContentByType(wasteType: String): Flow<DataState<List<Content>>> =
        object : NetworkBoundResource<List<Content>, List<ContentResponse>>() {
            override fun loadFromDB(): Flow<List<Content>> =
                localDataSource.getContentByType(wasteType).map {
                    contentMapper.mapFromCacheEntityList(it)
                }

            override fun shouldFetch(data: List<Content>?): Boolean =
                data == null || data.isEmpty()


            override suspend fun createCall(): Flow<ApiResponse<List<ContentResponse>>> =
                remoteDataSource.getContentByType(wasteType)

            override suspend fun saveCallResult(data: List<ContentResponse>) {
                val content = contentMapper.mapToCacheEntityList(data)
                localDataSource.insertContent(content)
            }

        }.asFlow()

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