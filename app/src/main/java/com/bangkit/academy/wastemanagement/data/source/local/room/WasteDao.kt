package com.bangkit.academy.wastemanagement.data.source.local.room

import androidx.room.*
import com.bangkit.academy.wastemanagement.data.source.local.entity.ContentEntity
import com.bangkit.academy.wastemanagement.data.source.local.entity.ImageEntity
import com.bangkit.academy.wastemanagement.data.source.local.entity.WasteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WasteDao {
    @Query("SELECT * FROM wasteEntity")
    fun getWaste(): Flow<List<WasteEntity>>

    @Query("SELECT * FROM wasteEntity WHERE idClass = :id")
    fun getWasteById(id: Int): Flow<WasteEntity>

    @Query("SELECT * FROM imageEntity")
    fun getImages(): Flow<List<ImageEntity>>

    @Query("SELECT * FROM imageEntity WHERE imageId = :id")
    fun getImageById(id: Int): Flow<ImageEntity>

    @Query("SELECT * FROM contentEntity")
    fun getContent(): Flow<List<ContentEntity>>

    @Query("SELECT * FROM contentEntity WHERE idContent = :id")
    fun getContentById(id: Int): Flow<ContentEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertContent(content: ContentEntity)

    @Update
    fun updateContent(content: ContentEntity)

    @Query("SELECT * FROM contentEntity WHERE isBookmarked = 1")
    fun getBookmarkedContent(): Flow<List<ContentEntity>>
}