package com.bangkit.academy.wastemanagement.data.source.local.room

import androidx.room.Dao
import androidx.room.Query
import com.bangkit.academy.wastemanagement.data.source.local.entity.ContentEntity
import com.bangkit.academy.wastemanagement.data.source.local.entity.ImageEntity
import com.bangkit.academy.wastemanagement.data.source.local.entity.WasteEntity

@Dao
interface WasteDao {
    @Query("SELECT * FROM wasteEntity")
    fun getWaste(): List<WasteEntity>

    @Query("SELECT * FROM imageEntity")
    fun getImages(): List<ImageEntity>

    @Query("SELECT * FROM contentEntity")
    fun getContent(): List<ContentEntity>
}