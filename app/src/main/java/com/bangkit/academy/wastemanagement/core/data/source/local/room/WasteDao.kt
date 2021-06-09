package com.bangkit.academy.wastemanagement.core.data.source.local.room

import androidx.room.*
import com.bangkit.academy.wastemanagement.core.data.source.local.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WasteDao {
    @Query("SELECT * FROM wasteEntity")
    fun getWaste(): Flow<List<WasteEntity>>

    @Query("SELECT * FROM wasteEntity WHERE id = :id")
    fun getWasteById(id: Int): Flow<WasteEntity>

    @Query("SELECT * FROM wasteEntity WHERE wasteType = :wasteType")
    fun getWasteByType(wasteType: String): Flow<WasteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWaste(waste: List<WasteEntity>)

    @Query("SELECT * FROM predictEntity")
    fun getPrediction(): Flow<List<PredictEntity>>

    @Delete
    suspend fun deletePredictionHistory(history: HistoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrediction(prediction: List<PredictEntity>)

    @Update
    suspend fun updatePrediction(prediction: PredictEntity)

    @Query("SELECT * FROM historyEntity WHERE history = 1")
    fun getHistory(): Flow<List<HistoryEntity>>

    @Insert
    suspend fun insertHistory(history: HistoryEntity)

    @Query("SELECT * FROM imageEntity")
    fun getImages(): Flow<List<ImageEntity>>

    @Query("SELECT * FROM imageEntity WHERE imageId = :id")
    fun getImageById(id: Int): Flow<ImageEntity>

    @Query("SELECT * FROM contentEntity")
    fun getContent(): Flow<List<ContentEntity>>

    @Query("SELECT * FROM contentEntity WHERE wasteType = :wasteType")
    fun getContentByType(wasteType: String): Flow<List<ContentEntity>>

    @Query("SELECT * FROM contentEntity WHERE id = :id")
    fun getContentById(id: Int): Flow<ContentEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContent(content: List<ContentEntity>)

    @Update
    fun updateContent(content: ContentEntity)

    @Query("SELECT * FROM contentEntity WHERE isBookmarked = 1")
    fun getBookmarkedContent(): Flow<List<ContentEntity>>
}