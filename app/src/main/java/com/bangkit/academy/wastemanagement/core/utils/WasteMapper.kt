package com.bangkit.academy.wastemanagement.core.utils

import android.util.Log
import com.bangkit.academy.wastemanagement.core.data.source.local.entity.WasteEntity
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.WasteResponse
import com.bangkit.academy.wastemanagement.core.domain.model.Waste
import javax.inject.Inject

class WasteMapper @Inject constructor() {
    fun mapFromCacheEntity(entity: WasteEntity): Waste {
        return Waste(
            id = entity.id,
            wasteType = entity.wasteType,
            description = entity.description
        )
    }

    fun mapFromNetworkToCacheEntity(entity: WasteResponse): WasteEntity {
        return WasteEntity(
            id = entity.id,
            wasteType = entity.wasteType,
            description = entity.description
        )
    }

    fun mapFromCacheEntityList(entities: List<WasteEntity>): List<Waste> {
        Log.d("from entities", entities.toString())
        val wasteList = ArrayList<Waste>()
        entities.map {
            val waste = Waste(
                id = it.id,
                wasteType = it.wasteType,
                description = it.description

            )
            wasteList.add(waste)
        }
        return wasteList
    }

    fun mapFromNetworkEntity(entity: WasteResponse): Waste {
        return Waste(
            id = entity.id,
            wasteType = entity.wasteType,
            description = entity.description
        )
    }

    fun mapToNetworkEntity(domainModel: Waste): WasteResponse {
        return WasteResponse(
            id = domainModel.id,
            wasteType = domainModel.wasteType,
            description = domainModel.description
        )
    }

    fun mapFromNetworkEntityList(entities: List<WasteResponse>): List<WasteEntity> {
        return entities.map { mapFromNetworkToCacheEntity(it) }
    }


}