package com.bangkit.academy.wastemanagement.core.utils

import com.bangkit.academy.wastemanagement.core.data.source.local.entity.ContentEntity
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.ContentResponse
import com.bangkit.academy.wastemanagement.core.domain.model.Content
import javax.inject.Inject

class ContentMapper @Inject constructor() {

    fun mapFromCacheEntity(entity: ContentEntity): Content {
        return Content(
            idContent = entity.idContent,
            titleContent = entity.titleContent,
            wasteType = entity.wasteType,
            imageUrl = entity.imageUrl,
            content = entity.content,
            isBookmarked = entity.isBookmarked
        )
    }

    fun mapToCacheEntity(domainModel: Content): ContentEntity {
        return ContentEntity(
            idContent = domainModel.idContent,
            titleContent = domainModel.titleContent,
            wasteType = domainModel.wasteType,
            imageUrl = domainModel.imageUrl,
            content = domainModel.content,
            isBookmarked = domainModel.isBookmarked
        )
    }

    fun mapFromCacheEntityList(entities: List<ContentEntity>): List<Content> {
        return entities.map { mapFromCacheEntity(it) }
    }

    fun mapFromNetworkEntity(entity: ContentResponse): Content {
        return Content(
            idContent = entity.idContent,
            titleContent = entity.titleContent,
            wasteType = entity.wasteType,
            imageUrl = entity.imageUrl,
            content = entity.content
        )
    }

    fun mapToCacheEntity(entity: ContentResponse): ContentEntity {
        return ContentEntity(
            idContent = entity.idContent,
            titleContent = entity.titleContent,
            wasteType = entity.wasteType,
            imageUrl = entity.imageUrl,
            content = entity.content
        )
    }


    fun mapToNetworkEntity(domainModel: Content): ContentResponse {
        return ContentResponse(
            idContent = domainModel.idContent,
            titleContent = domainModel.titleContent,
            wasteType = domainModel.wasteType,
            imageUrl = domainModel.imageUrl,
            content = domainModel.content
        )
    }

    fun mapFromNetworkEntityList(entities: List<ContentResponse>): List<Content> {
        return entities.map{ mapFromNetworkEntity(it) }
    }

    fun mapToCacheEntityList(entities: List<ContentResponse>): List<ContentEntity> {
        return entities.map{ mapToCacheEntity(it) }
    }


}