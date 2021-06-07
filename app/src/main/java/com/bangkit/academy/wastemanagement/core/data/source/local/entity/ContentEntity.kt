package com.bangkit.academy.wastemanagement.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contentEntity")
data class ContentEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    @NonNull
    var idContent: Int,

    @ColumnInfo(name = "title")
    var titleContent: String,

    @ColumnInfo(name = "wasteType")
    var wasteType: String,

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "isBookmarked")
    var isBookmarked: Boolean = false

)
