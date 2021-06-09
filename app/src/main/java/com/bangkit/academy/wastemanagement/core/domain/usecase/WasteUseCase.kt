package com.bangkit.academy.wastemanagement.core.domain.usecase

import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.domain.model.*
import kotlinx.coroutines.flow.Flow
import java.io.File

interface WasteUseCase {
    fun getWaste(): Flow<DataState<List<Waste>>>

    fun getWasteById(id: Int): Flow<DataState<Waste>>

    fun getWasteByType(wasteType: String): Flow<DataState<Waste>>

    fun getPrediction(pic: File): Flow<DataState<List<Predict>>>

    fun getPredictionHistory(): Flow<DataState<List<History>>>

    fun deletePredictionHistory(history: History)

    fun setImagePrediction(prediction: Predict, imageUrl: String, history: Boolean)

    fun getImages(): Flow<DataState<List<Image>>>

    fun getImageById(id: Int): Flow<DataState<Image>>

    fun getContent(): Flow<DataState<List<Content>>>

    fun getContentByType(wasteType: String): Flow<DataState<List<Content>>>

    fun getContentById(id: Int): Flow<DataState<Content>>

    fun getBookmarkedContent(): Flow<List<Content>>

    fun setBookmarkedContent(content: Content, state: Boolean)


}