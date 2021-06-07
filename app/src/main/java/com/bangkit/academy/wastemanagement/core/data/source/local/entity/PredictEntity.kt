package com.bangkit.academy.wastemanagement.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "predictEntity")
data class PredictEntity(
    @ColumnInfo(name = "wasteType")
    @PrimaryKey
    var wasteType: String,

    @ColumnInfo(name= "prediction")
    @NonNull
    var prediction: Float
)
