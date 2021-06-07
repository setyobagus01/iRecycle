package com.bangkit.academy.wastemanagement.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image (
    val imageId: Int,
    val imageUrl: String,
    val idClass: Int
): Parcelable