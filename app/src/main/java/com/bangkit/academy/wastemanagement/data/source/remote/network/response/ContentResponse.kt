package com.bangkit.academy.wastemanagement.data.source.remote.network.response

import com.google.gson.annotations.SerializedName

data class ContentResponse(
    @field:SerializedName("idContent")
    var idContent: Int,

    @field:SerializedName("titleContent")
    var titleContent: String,

    @field:SerializedName("wasteType")
    var wasteType: String,

    @field:SerializedName("content")
    var content: String,

    @field:SerializedName("imageUrl")
    var imageUrl: String
)