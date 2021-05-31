package com.bangkit.academy.wastemanagement.data.source.repository

import com.bangkit.academy.wastemanagement.data.source.local.LocalDataSource
import com.bangkit.academy.wastemanagement.data.source.local.room.WasteDao
import com.bangkit.academy.wastemanagement.data.source.remote.RemoteDataSource

class WasteRepository(
    private val wasteDao: WasteDao,
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

}