package com.bangkit.academy.wastemanagement.core.domain.model

data class History(
    var id: Int,
    var wasteType: String,
    var prediction: Float,
    var imageUrl: String,
    var history: Boolean = false
)
