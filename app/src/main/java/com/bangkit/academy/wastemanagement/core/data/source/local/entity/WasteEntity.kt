package com.bangkit.academy.wastemanagement.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wasteEntity")
data class WasteEntity(
    @ColumnInfo(name = "idClass")
    @PrimaryKey
    @NonNull
    var id: Int,

    @ColumnInfo(name = "className")
    var wasteType: String,

    @ColumnInfo(name = "classDescription")
    var description: String
)