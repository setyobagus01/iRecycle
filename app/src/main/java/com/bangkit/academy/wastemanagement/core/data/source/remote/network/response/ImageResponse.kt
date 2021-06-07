package com.bangkit.academy.wastemanagement.core.data.source.remote.network.response

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    @field:SerializedName("imageId")
    var imageId: Int,

    @field:SerializedName("imageUrl")
    var imageUrl: String,

    @field:SerializedName("idClass")
    var idClass: Int
)
