package com.bangkit.academy.wastemanagement.core.domain.usecase

import com.bangkit.academy.wastemanagement.core.domain.model.Content
import com.bangkit.academy.wastemanagement.core.domain.repository.IWasteRepository
import javax.inject.Inject

class WasteInteractor @Inject constructor(private val wasteRepository: IWasteRepository) : WasteUseCase {
    override fun getWaste() = wasteRepository.getWaste()

    override fun getWasteById(id: Int) = wasteRepository.getWasteById(id)

    override fun getImages() = wasteRepository.getImages()

    override fun getImageById(id: Int) = wasteRepository.getImageById(id)

    override fun getContent() = wasteRepository.getContent()

    override fun getContentById(id: Int) = wasteRepository.getContentById(id)

    override fun getBookmarkedContent() = wasteRepository.getBookmarkedContent()

    override fun setBookmarkedContent(content: Content, state: Boolean) {
        return wasteRepository.setBookmarkedContent(content, state)
    }

}