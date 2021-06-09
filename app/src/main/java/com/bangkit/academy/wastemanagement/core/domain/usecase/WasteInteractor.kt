package com.bangkit.academy.wastemanagement.core.domain.usecase

import com.bangkit.academy.wastemanagement.core.data.DataState
import com.bangkit.academy.wastemanagement.core.domain.model.Content
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import com.bangkit.academy.wastemanagement.core.domain.model.Waste
import com.bangkit.academy.wastemanagement.core.domain.repository.IWasteRepository
import kotlinx.coroutines.flow.Flow
import java.io.File
import javax.inject.Inject

class WasteInteractor @Inject constructor(private val wasteRepository: IWasteRepository) : WasteUseCase {
    override fun getWaste() = wasteRepository.getWaste()

    override fun getWasteById(id: Int) = wasteRepository.getWasteById(id)

    override fun getWasteByType(wasteType: String): Flow<DataState<Waste>> = wasteRepository.getWasteByType(wasteType)

    override fun getPrediction(pic: File): Flow<DataState<List<Predict>>> = wasteRepository.getPrediction(pic)
    override fun getPredictionHistory(): Flow<DataState<List<Predict>>> = wasteRepository.getPredictionHistory()

    override fun setImagePrediction(prediction: Predict, imageUrl: String, history: Boolean) {
        return wasteRepository.setImagePrediction(prediction, imageUrl, history)
    }

    override fun getImages() = wasteRepository.getImages()

    override fun getImageById(id: Int) = wasteRepository.getImageById(id)

    override fun getContent() = wasteRepository.getContent()

    override fun getContentByType(wasteType: String): Flow<DataState<List<Content>>> = wasteRepository.getContentByType(wasteType)

    override fun getContentById(id: Int) = wasteRepository.getContentById(id)

    override fun getBookmarkedContent() = wasteRepository.getBookmarkedContent()

    override fun setBookmarkedContent(content: Content, state: Boolean) {
        return wasteRepository.setBookmarkedContent(content, state)
    }


}