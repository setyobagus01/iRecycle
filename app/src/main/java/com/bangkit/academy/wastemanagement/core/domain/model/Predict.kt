package com.bangkit.academy.wastemanagement.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Predict(
    val wasteType: String,
    val prediction: Float
): Parcelable
