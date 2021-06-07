package com.bangkit.academy.wastemanagement.core.data.source.remote.retrofit

import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.ContentResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.PredictResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.WasteResponse
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @GET("api/waste")
    suspend fun getWaste(): List<WasteResponse>

    @GET("api/content")
    suspend fun getContent(): List<ContentResponse>


    @POST("api/predict")
    @Multipart
    suspend fun getPrediction(@Part pic: MultipartBody.Part): List<PredictResponse>
}