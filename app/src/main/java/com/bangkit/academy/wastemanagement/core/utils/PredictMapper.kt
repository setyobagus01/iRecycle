package com.bangkit.academy.wastemanagement.core.utils

import com.bangkit.academy.wastemanagement.core.data.source.local.entity.PredictEntity
import com.bangkit.academy.wastemanagement.core.data.source.remote.network.response.PredictResponse
import com.bangkit.academy.wastemanagement.core.domain.model.Predict
import javax.inject.Inject

class PredictMapper @Inject constructor() {
    fun mapFromCacheEntity(entity: PredictEntity): Predict {
        return Predict(
            wasteType = entity.wasteType,
            prediction = entity.prediction
        )
    }

    fun mapFromNetworkToCacheEntity(entity: PredictResponse): PredictEntity {
        return PredictEntity(
            wasteType = entity.wasteType,
            prediction = entity.prediction
        )
    }

    fun mapFromCacheEntityList(entities: List<PredictEntity>): List<Predict> {
        return entities.map { mapFromCacheEntity(it) }
    }

    fun mapFromDomain(domainModel: Predict): PredictEntity {
        return PredictEntity(
            wasteType = domainModel.wasteType,
            prediction = domainModel.prediction
        )
    }

    fun mapFromNetworkEntity(entity: PredictResponse): Predict {
        return Predict(
            wasteType = entity.wasteType,
            prediction = entity.prediction
        )
    }

    fun mapToNetworkEntity(domainModel: Predict): PredictResponse {
        return PredictResponse(
            wasteType = domainModel.wasteType,
            prediction = domainModel.prediction
        )
    }

    fun mapFromNetworkEntityList(entities: List<PredictResponse>): List<PredictEntity> {
        return entities.map { mapFromNetworkToCacheEntity(it) }
    }

}