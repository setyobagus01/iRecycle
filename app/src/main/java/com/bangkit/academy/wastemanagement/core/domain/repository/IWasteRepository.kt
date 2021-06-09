package com.bangkit.academy.wastemanagement.core.domain.repository

import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.domain.model.Content
import com.bangkit.academy.wastemanagement.core.domain.model.Image
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.core.domain.model.Waste
import kotlinx.coroutines.flow.Flow
import java.io.File

interface IWasteRepository {
    fun getWaste(): Flow<DataState<List<Waste>>>

    fun getWasteById(id: Int): Flow<DataState<Waste>>

    fun getWasteByType(wasteType: String): Flow<DataState<Waste>>

    fun getPrediction(pic: File): Flow<DataState<List<Predict>>>

    fun getPredictionHistory(): Flow<DataState<List<Predict>>>

    fun setImagePrediction(prediction: Predict, imageUrl: String, history: Boolean)

    fun getImages(): Flow<DataState<List<Image>>>

    fun getImageById(id: Int): Flow<DataState<Image>>

    fun getContent(): Flow<DataState<List<Content>>>

    fun getContentByType(wasteType: String): Flow<DataState<List<Content>>>

    fun getContentById(id: Int): Flow<DataState<Content>>

    fun getBookmarkedContent(): Flow<List<Content>>

    fun setBookmarkedContent(content: Content, state: Boolean)


}