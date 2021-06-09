package com.bangkit.academy.wastemanagement.core.data.source.local

import com.bangkit.academy.wastemanagement.core.data.source.local.entity.*
import com.bangkit.academy.wastemanagement.core.data.source.local.room.WasteDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val wasteDao: WasteDao) {
    fun getWaste(): Flow<List<WasteEntity>> = wasteDao.getWaste()

    fun getWasteById(id: Int): Flow<WasteEntity> = wasteDao.getWasteById(id)

    fun getWasteByType(wasteType: String): Flow<WasteEntity> = wasteDao.getWasteByType(wasteType)

    suspend fun insertWaste(waste: List<WasteEntity>) = wasteDao.insertWaste(waste)

    fun getPrediction(): Flow<List<PredictEntity>> = wasteDao.getPrediction()

    suspend fun insertPrediction(prediction: List<PredictEntity>) = wasteDao.insertPrediction(prediction)

    suspend fun updatePrediction(prediction: PredictEntity, imageUrl: String, newState: Boolean) {
        prediction.imageUrl = imageUrl
        prediction.history = newState
        wasteDao.updatePrediction(prediction)

    }

    fun getHistory(): Flow<List<HistoryEntity>> = wasteDao.getHistory()

    suspend fun insertHistory(history: HistoryEntity) = wasteDao.insertHistory(history)

    suspend fun deletePredictionHistory(history: HistoryEntity) = wasteDao.deletePredictionHistory(history)

    fun getImages(): Flow<List<ImageEntity>> = wasteDao.getImages()

    fun getImageById(id: Int): Flow<ImageEntity> = wasteDao.getImageById(id)

    fun getContent(): Flow<List<ContentEntity>> = wasteDao.getContent()

    fun getContentByType(wasteType: String): Flow<List<ContentEntity>> = wasteDao.getContentByType(wasteType)

    fun getContentById(id: Int): Flow<ContentEntity> = wasteDao.getContentById(id)

    suspend fun insertContent(content: List<ContentEntity>) = wasteDao.insertContent(content)

    fun updateContent(content: ContentEntity, state: Boolean) {
        content.isBookmarked = state
        wasteDao.updateContent(content)
    }

    fun getBookmarkedContent(): Flow<List<ContentEntity>> = wasteDao.getBookmarkedContent()
}