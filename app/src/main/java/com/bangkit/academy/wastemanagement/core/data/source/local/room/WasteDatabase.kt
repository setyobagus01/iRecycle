package com.bangkit.academy.wastemanagement.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bangkit.academy.wastemanagement.core.data.source.local.entity.*

@Database(
    entities = [WasteEntity::class, ImageEntity::class, ContentEntity::class, PredictEntity::class, HistoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WasteDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME: String = "WasteManagement.db"
    }
    abstract fun wasteDao(): WasteDao
}