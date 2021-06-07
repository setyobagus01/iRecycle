package com.bangkit.academy.wastemanagement.core.data.source.remote.network.response

import com.google.gson.annotations.SerializedName

data class WasteResponse(
    @field:SerializedName("id")
    var id: Int,

    @field:SerializedName("wasteType")
    var wasteType: String,

    @field:SerializedName("description")
    var description: String
)
