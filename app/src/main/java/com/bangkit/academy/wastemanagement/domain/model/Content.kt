package com.bangkit.academy.wastemanagement.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    val idContent: Int,
    val titleContent: String,
    val wasteType: String,
    val content: String,
    val imageUrl: String,
    var isBookmarked: Boolean = false
) : Parcelable
