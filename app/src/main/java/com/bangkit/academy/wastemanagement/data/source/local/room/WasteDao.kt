package com.bangkit.academy.wastemanagement.data.source.local.room

import androidx.room.Dao
import androidx.room.Query
import com.bangkit.academy.wastemanagement.data.source.local.entity.ContentEntity
import com.bangkit.academy.wastemanagement.data.source.local.entity.ImageEntity
import com.bangkit.academy.wastemanagement.data.source.local.entity.WasteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WasteDao {
    @Query("SELECT * FROM wasteEntity")
    fun getWaste(): Flow<List<WasteEntity>>

    @Query("SELECT * FROM imageEntity")
    fun getImages(): Flow<List<ImageEntity>>

    @Query("SELECT * FROM contentEntity")
    fun getContent(): Flow<List<ContentEntity>>
}