package com.bangkit.academy.wastemanagement.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historyEntity")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "wasteType")
    var wasteType: String,

    @ColumnInfo(name = "prediction")
    @NonNull
    var prediction: Float,

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String,

    @ColumnInfo(name = "history")
    var history: Boolean = false
)