package com.bangkit.academy.wastemanagement.core.data.source.remote.network.response

import com.google.gson.annotations.SerializedName

data class ContentResponse(
    @field:SerializedName("id")
    var idContent: Int,

    @field:SerializedName("title")
    var titleContent: String,

    @field:SerializedName("wasteType")
    var wasteType: String,

    @field:SerializedName("imageUrl")
    var imageUrl: String,

    @field:SerializedName("content")
    var content: String
)