package com.bangkit.academy.wastemanagement.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waste(
    val id: Int,
    val wasteType: String,
    val description: String
) : Parcelable