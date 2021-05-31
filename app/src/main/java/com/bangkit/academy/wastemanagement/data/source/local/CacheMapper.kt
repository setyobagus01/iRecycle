package com.bangkit.academy.wastemanagement.data.source.local

import com.bangkit.academy.wastemanagement.data.EntityMapper
import com.bangkit.academy.wastemanagement.data.source.local.entity.ContentEntity
import com.bangkit.academy.wastemanagement.domain.model.Content
import javax.inject.Inject

class CacheMapper @Inject constructor() : EntityMapper<ContentEntity, Content> {
    override fun mapFromEntity(entity: ContentEntity): Content {
        return Content(
            idContent = entity.idContent,
            titleContent = entity.titleContent,
            wasteType = entity.wasteType,
            imageUrl = entity.imageUrl,
            content = entity.content,
            isBookmarked = entity.isBookmarked
        )
    }

    override fun mapToEntity(domainModel: Content): ContentEntity {
        return ContentEntity(
            idContent = domainModel.idContent,
            titleContent = domainModel.titleContent,
            wasteType = domainModel.wasteType,
            imageUrl = domainModel.imageUrl,
            content = domainModel.content,
            isBookmarked = domainModel.isBookmarked
        )
    }

}