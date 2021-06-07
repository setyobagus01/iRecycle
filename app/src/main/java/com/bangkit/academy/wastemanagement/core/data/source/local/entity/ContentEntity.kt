package com.bangkit.academy.wastemanagement.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contentEntity")
data class ContentEntity(
    @ColumnInfo(name = "idContent")
    @PrimaryKey
    @NonNull
    var idContent: Int,

    @ColumnInfo(name = "titleContent")
    var titleContent: String,

    @ColumnInfo(name = "categoryTitle")
    var wasteType: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "imageUrl")
    var imageUrl: String,

    @ColumnInfo(name = "isBookmarked")
    var isBookmarked: Boolean = false

)
