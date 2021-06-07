package com.bangkit.academy.wastemanagement.core.data.source.remote.network.response

import com.google.gson.annotations.SerializedName

data class PredictResponse(
    @field:SerializedName("wasteType")
    var wasteType: String,

    @field:SerializedName("prediction")
    var prediction: Float
)
