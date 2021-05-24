package com.bangkit.academy.wastemanagement.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "imageEntity")
data class ImageEntity(
    @ColumnInfo(name = "imageId")
    @PrimaryKey
    @NonNull
    var imageId: Int,

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String,

    @ColumnInfo(name = "idClass")
    var idClass: Int
)