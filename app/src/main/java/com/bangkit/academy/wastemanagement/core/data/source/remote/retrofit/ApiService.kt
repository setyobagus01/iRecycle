package com.bangkit.academy.wastemanagement.core.data.source.remote.retrofit

import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.ContentResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.PredictResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.WasteResponse
import okhttp3.MultipartBody
import retrofit2.http.*

interface ApiService {
    @GET("api/waste")
    suspend fun getWaste(): List<WasteResponse>

    @GET("api/content")
    suspend fun getContent(): List<ContentResponse>

    @GET("api/content")
    suspend fun getContentByType(@Query("wasteType") wasteType: String): List<ContentResponse>


    @POST("api/predict")
    @Multipart
    suspend fun getPrediction(@Part pic: MultipartBody.Part): List<PredictResponse>
}