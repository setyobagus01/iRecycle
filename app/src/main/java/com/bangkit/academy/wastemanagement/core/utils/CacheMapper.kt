package com.bangkit.academy.wastemanagement.core.utils

interface CacheMapper<Entity, DomainModel> {
    fun mapFromCacheEntity(entity: Entity): DomainModel

    fun mapToCacheEntity(domainModel: DomainModel): Entity
}