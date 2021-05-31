package com.bangkit.academy.wastemanagement.data.source.remote

import com.bangkit.academy.wastemanagement.data.EntityMapper
import com.bangkit.academy.wastemanagement.data.source.remote.network.response.ContentResponse
import com.bangkit.academy.wastemanagement.domain.model.Content
import javax.inject.Inject

class NetworkMapper @Inject constructor() : EntityMapper<ContentResponse, Content> {
    override fun mapFromEntity(entity: ContentResponse): Content {
        return Content(
            idContent = entity.idContent,
            titleContent = entity.titleContent,
            wasteType = entity.wasteType,
            imageUrl = entity.wasteType,
            content = entity.content
        )
    }

    override fun mapToEntity(domainModel: Content): ContentResponse {
        return ContentResponse(
            idContent = domainModel.idContent,
            titleContent = domainModel.titleContent,
            wasteType = domainModel.wasteType,
            imageUrl = domainModel.wasteType,
            content = domainModel.content
        )
    }

}