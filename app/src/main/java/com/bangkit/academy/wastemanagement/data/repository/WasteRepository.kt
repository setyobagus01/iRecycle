package com.bangkit.academy.wastemanagement.data.repository

import androidx.lifecycle.LiveData
import com.bangkit.academy.wastemanagement.data.DataState
import com.bangkit.academy.wastemanagement.data.source.local.CacheMapper
import com.bangkit.academy.wastemanagement.data.source.local.LocalDataSource
import com.bangkit.academy.wastemanagement.data.source.remote.RemoteDataSource
import com.bangkit.academy.wastemanagement.domain.model.Content
import com.bangkit.academy.wastemanagement.domain.model.Image
import com.bangkit.academy.wastemanagement.domain.model.Waste
import com.bangkit.academy.wastemanagement.domain.repository.IWasteRepository

class WasteRepository constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val cacheMapper: CacheMapper
): IWasteRepository {
    override fun getWaste(): LiveData<DataState<List<Waste>>> {
        TODO("Not yet implemented")
    }

    override fun getWasteById(id: Int): LiveData<DataState<Waste>> {
        TODO("Not yet implemented")
    }

    override fun getImages(): LiveData<DataState<List<Image>>> {
        TODO("Not yet implemented")
    }

    override fun getImageById(id: Int): LiveData<DataState<Image>> {
        TODO("Not yet implemented")
    }

    override fun getContent(): LiveData<DataState<List<Content>>> {
        TODO("Not yet implemented")
    }

    override fun getContentById(id: Int): LiveData<DataState<Content>> {
        TODO("Not yet implemented")
    }

    override fun getBookmarkedContent(): LiveData<List<Content>> {
        TODO("Not yet implemented")
    }

    override fun setBookmarkedContent(content: Content, state: Boolean) {
        TODO("Not yet implemented")
    }

}