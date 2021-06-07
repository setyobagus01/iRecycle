package com.bangkit.academy.wastemanagement.core.data.source.remote.retrofit

import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.ContentResponse
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.WasteResponse
import retrofit2.http.GET

interface ApiService {
    @GET("api/waste")
    suspend fun getWaste(): List<WasteResponse>

    @GET("api/content")
    suspend fun getContent(): List<ContentResponse>
}