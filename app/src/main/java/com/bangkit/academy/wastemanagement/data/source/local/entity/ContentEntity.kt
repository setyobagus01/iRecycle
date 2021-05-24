package com.bangkit.academy.wastemanagement.data.source.local.entity

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
    var categoryContent: String,

    @ColumnInfo(name = "content")
    var content: String,

    @ColumnInfo(name = "isBookmarked")
    var isBookmarked: Boolean = false

)
