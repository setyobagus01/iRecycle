package com.bangkit.academy.wastemanagement.data.source.local

import com.bangkit.academy.wastemanagement.data.source.local.entity.WasteEntity
import com.bangkit.academy.wastemanagement.data.source.local.room.WasteDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource constructor(private val wasteDao: WasteDao) {
    fun getAllWaste(): Flow<List<WasteEntity>> = wasteDao.getWaste()
}