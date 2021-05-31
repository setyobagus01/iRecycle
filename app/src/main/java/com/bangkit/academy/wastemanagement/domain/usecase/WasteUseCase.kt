package com.bangkit.academy.wastemanagement.domain.usecase

import androidx.lifecycle.LiveData
import com.bangkit.academy.wastemanagement.data.DataState
import com.bangkit.academy.wastemanagement.domain.model.Content
import com.bangkit.academy.wastemanagement.domain.model.Image
import com.bangkit.academy.wastemanagement.domain.model.Waste

interface WasteUseCase {
    fun getWaste(): LiveData<DataState<List<Waste>>>

    fun getWasteById(id: Int): LiveData<DataState<Waste>>

    fun getImages(): LiveData<DataState<List<Image>>>

    fun getImageById(id: Int): LiveData<DataState<Image>>

    fun getContent(): LiveData<DataState<List<Content>>>

    fun getContentById(id: Int): LiveData<DataState<Content>>

    fun getBookmarkedContent(): LiveData<List<Content>>

    fun setBookmarkedContent(content: Content, state: Boolean)
}